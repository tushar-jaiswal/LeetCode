# Author: Tushar Jaiswal
# Creation Date: 2025-07-21

#  Problem Source: https://leetcode.com/problems/design-excel-sum-formula

# Design the basic function of Excel and implement the function of the sum formula.

# Implement the Excel class:
#     Excel(int height, char width) Initializes the object with the height and the width of the sheet. The sheet is an integer matrix mat of size height x width with the row index in the range [1, height] and the column index in the range ['A', width]. All the values should be zero initially.
#     void set(int row, char column, int val) Changes the value at mat[row][column] to be val.
#     int get(int row, char column) Returns the value at mat[row][column].
#     int sum(int row, char column, List<String> numbers) Sets the value at mat[row][column] to be the sum of cells represented by numbers and returns the value at mat[row][column]. This sum formula should exist until this cell is overlapped by another value or another sum formula. numbers[i] could be on the format:
#         "ColRow" that represents a single cell.
#             For example, "F7" represents the cell mat[7]['F'].
#         "ColRow1:ColRow2" that represents a range of cells. The range will always be a rectangle where "ColRow1" represent the position of the top-left cell, and "ColRow2" represents the position of the bottom-right cell.
#             For example, "B3:F7" represents the cells mat[i][j] for 3 <= i <= 7 and 'B' <= j <= 'F'.

# Note: You could assume that there will not be any circular sum reference.
#   * For example, mat[1]['A'] == sum(1, "B") and mat[1]['B'] == sum(1, "A").

# Example 1:
# Input
# ["Excel", "set", "sum", "set", "get"]
# [[3, "C"], [1, "A", 2], [3, "C", ["A1", "A1:B2"]], [2, "B", 2], [3, "C"]]
# Output
# [null, null, 4, null, 6]

# Explanation
# Excel excel = new Excel(3, "C");
#  // construct a 3*3 2D array with all zero.
#  //   A B C
#  // 1 0 0 0
#  // 2 0 0 0
#  // 3 0 0 0
# excel.set(1, "A", 2);
#  // set mat[1]["A"] to be 2.
#  //   A B C
#  // 1 2 0 0
#  // 2 0 0 0
#  // 3 0 0 0
# excel.sum(3, "C", ["A1", "A1:B2"]); // return 4
#  // set mat[3]["C"] to be the sum of value at mat[1]["A"] and the values sum of the rectangle range whose top-left cell is mat[1]["A"] and bottom-right cell is mat[2]["B"].
#  //   A B C
#  // 1 2 0 0
#  // 2 0 0 0
#  // 3 0 0 4
# excel.set(2, "B", 2);
#  // set mat[2]["B"] to be 2. Note mat[3]["C"] should also be changed.
#  //   A B C
#  // 1 2 0 0
#  // 2 0 2 0
#  // 3 0 0 6
# excel.get(3, "C"); // return 6

# Constraints:
#     1 <= height <= 26
#     'A' <= width <= 'Z'
#     1 <= row <= height
#     'A' <= column <= width
#     -100 <= val <= 100
#     1 <= numbers.length <= 5
#     numbers[i] has the format "ColRow" or "ColRow1:ColRow2".
#     At most 100 calls will be made to set, get, and sum.


# Runtime Complexity:
# Here, r and c refer to the number of rows and columns in the current Excel Form.
# * init is O(r * c)
# * set is O(r * c) + (r * c)(r * c)!
#    * (r * c) - a formula could have all but current cell which were reporting to the formula in the cell.
#    * (r * c)(r * c)! - update_cells_where_in_formula
#      * This cell could be in formula for all other cells i.e. (r * c). 
#      * Those cells themselves could be in formula for other cells except the cells that are in their formula i.e. (r * c)!
#    * (r * c) + (r * c)(r * c)!- summation of the above two as they were sequential operations.
# * sum is O(r * c) + (r * c)(r * c)!
#    * (r * c) - a formula could have all but current cell which were reporting to the formula in the cell.
#    * (r * c)(r * c)!
#      * This cell could be in formula for all other cells i.e. (r * c). 
#      * Those cells themselves could be in formula for other cells except the cells that are in their formula i.e. (r * c)!
#    * (r * c) + (r * c)(r * c)!- summation of the above two as they were sequential operations.
# * get is O(1)
# Space Complexity: 
# The space required will be O((r * c)^2) in the worst case. 
# * O(r * c) space will be required for the Excel Form itself. 
# * For each cell in this form, the cells_where_in_formula list can contain O(r * c) cells.

class Cell:
    def __init__(self, row: int, col: str, val: int = 0, formula_cells: list = None, formula: List[str] = None):
        self.row = row
        self.col = col
        self.val = val
        self.cells_where_in_formula = formula_cells # must be a list as the same cell can be present multiple times in formula
        self.formula = formula

class Excel:
    def __init__(self, height: int, width: str):
        self.graph = {}

        for row in range(1, height + 1):
            for col in range(ord('A'), ord(width) + 1): #ord() provides ASCII value of a character
                self.graph[str(row)+chr(col)] = Cell(row, chr(col), 0, []) #chr() converts an ASCII value to its character


    def set(self, row: int, column: str, val: int) -> None:
        cell_id = str(row) + column
        cell = self.graph[cell_id]

        # Remove cell formula as it is being replaced by a value. 
        # Also remove any cells that were reporting its value to formula
        if cell.formula:
            cells = self.get_cells_from_formula(cell.formula)
            for dependency_cell in cells:
                self.graph[dependency_cell].cells_where_in_formula.remove(cell_id)
            cell.formula = None
        
        # Update value of cells where this cell is in formula
        self.update_cells_where_in_formula(cell, cell.val, val)

        cell.val = val

    def get(self, row: int, column: str) -> int:
        cell_id = str(row) + column
        cell = self.graph[cell_id]
        return cell.val

    def sum(self, row: int, column: str, numbers: List[str]) -> int:
        cell_id = str(row) + column
        cell = self.graph[cell_id]

        # Remove cell formula as it is being replaced by a new formula. 
        # Also remove any cells that were reporting its value to formula
        if cell.formula:
            cells = self.get_cells_from_formula(cell.formula)
            for dependency_cell in cells:
                self.graph[dependency_cell].cells_where_in_formula.remove(cell_id)
        
        # Set new formula and add this cell id to cells that are in this formula
        cell.formula = numbers
        dependency_cells = self.get_cells_from_formula(cell.formula)
        old_val = cell.val
        cell.val = 0
        for dependency_cell in dependency_cells:
            self.graph[dependency_cell].cells_where_in_formula.append(cell_id)
            cell.val += self.graph[dependency_cell].val

        # Update value of cells where this cell is in formula
        self.update_cells_where_in_formula(cell, old_val, cell.val)

        return cell.val
    
    def get_cells_from_formula(self, formula: List[str]) -> list:
        cells = []

        for element in formula:
            if len(element) == 2:
                cells.append(element[1:]+element[0])
            else:
                split_list = element.split(":")
                start_col = split_list[0][0]
                end_col = split_list[1][0]
                start_row = int(split_list[0][1:])
                end_row = int(split_list[1][1:])
                for row in range(start_row, end_row + 1):
                    for col in range(ord(start_col), ord(end_col) + 1):
                        cells.append(str(row)+chr(col))
        return cells

    def update_cells_where_in_formula(self, cell: Cell, old_val, new_val):
        for dependent_cell in cell.cells_where_in_formula:
            dependent_old_val = self.graph[dependent_cell].val
            self.graph[dependent_cell].val -= old_val
            self.graph[dependent_cell].val += new_val
            dependent_new_val = self.graph[dependent_cell].val
            self.update_cells_where_in_formula(self.graph[dependent_cell], dependent_old_val, dependent_new_val)

        

# Your Excel object will be instantiated and called as such:
# obj = Excel(height, width)
# obj.set(row,column,val)
# param_2 = obj.get(row,column)
# param_3 = obj.sum(row,column,numbers)
