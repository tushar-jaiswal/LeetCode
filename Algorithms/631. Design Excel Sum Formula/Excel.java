// Author: Tushar Jaiswal
// Creation Date: 2025-07-21

//  Problem Source: https://leetcode.com/problems/design-excel-sum-formula

// Design the basic function of Excel and implement the function of the sum formula.

// Implement the Excel class:
//     Excel(int height, char width) Initializes the object with the height and the width of the sheet. The sheet is an integer matrix mat of size height x width with the row index in the range [1, height] and the column index in the range ['A', width]. All the values should be zero initially.
//     void set(int row, char column, int val) Changes the value at mat[row][column] to be val.
//     int get(int row, char column) Returns the value at mat[row][column].
//     int sum(int row, char column, List<String> numbers) Sets the value at mat[row][column] to be the sum of cells represented by numbers and returns the value at mat[row][column]. This sum formula should exist until this cell is overlapped by another value or another sum formula. numbers[i] could be on the format:
//         "ColRow" that represents a single cell.
//             For example, "F7" represents the cell mat[7]['F'].
//         "ColRow1:ColRow2" that represents a range of cells. The range will always be a rectangle where "ColRow1" represent the position of the top-left cell, and "ColRow2" represents the position of the bottom-right cell.
//             For example, "B3:F7" represents the cells mat[i][j] for 3 <= i <= 7 and 'B' <= j <= 'F'.

// Note: You could assume that there will not be any circular sum reference.
//   * For example, mat[1]['A'] == sum(1, "B") and mat[1]['B'] == sum(1, "A").

// Example 1:
// Input
// ["Excel", "set", "sum", "set", "get"]
// [[3, "C"], [1, "A", 2], [3, "C", ["A1", "A1:B2"]], [2, "B", 2], [3, "C"]]
// Output
// [null, null, 4, null, 6]

// Explanation
// Excel excel = new Excel(3, "C");
//  // construct a 3*3 2D array with all zero.
//  //   A B C
//  // 1 0 0 0
//  // 2 0 0 0
//  // 3 0 0 0
// excel.set(1, "A", 2);
//  // set mat[1]["A"] to be 2.
//  //   A B C
//  // 1 2 0 0
//  // 2 0 0 0
//  // 3 0 0 0
// excel.sum(3, "C", ["A1", "A1:B2"]); // return 4
//  // set mat[3]["C"] to be the sum of value at mat[1]["A"] and the values sum of the rectangle range whose top-left cell is mat[1]["A"] and bottom-right cell is mat[2]["B"].
//  //   A B C
//  // 1 2 0 0
//  // 2 0 0 0
//  // 3 0 0 4
// excel.set(2, "B", 2);
//  // set mat[2]["B"] to be 2. Note mat[3]["C"] should also be changed.
//  //   A B C
//  // 1 2 0 0
//  // 2 0 2 0
//  // 3 0 0 6
// excel.get(3, "C"); // return 6

// Constraints:
//     1 <= height <= 26
//     'A' <= width <= 'Z'
//     1 <= row <= height
//     'A' <= column <= width
//     -100 <= val <= 100
//     1 <= numbers.length <= 5
//     numbers[i] has the format "ColRow" or "ColRow1:ColRow2".
//     At most 100 calls will be made to set, get, and sum.


// Runtime Complexity:
// Here, r and c refer to the number of rows and columns in the current Excel Form.
// * init is O(r * c)
// * set is O(r * c) + (r * c)(r * c)!
//    * (r * c) - a formula could have all but current cell which were reporting to the formula in the cell.
//    * (r * c)(r * c)! - update_cells_where_in_formula
//      * This cell could be in formula for all other cells i.e. (r * c). 
//      * Those cells themselves could be in formula for other cells except the cells that are in their formula i.e. (r * c)!
//    * (r * c) + (r * c)(r * c)!- summation of the above two as they were sequential operations.
// * sum is O(r * c) + (r * c)(r * c)!
//    * (r * c) - a formula could have all but current cell which were reporting to the formula in the cell.
//    * (r * c)(r * c)!
//      * This cell could be in formula for all other cells i.e. (r * c). 
//      * Those cells themselves could be in formula for other cells except the cells that are in their formula i.e. (r * c)!
//    * (r * c) + (r * c)(r * c)!- summation of the above two as they were sequential operations.
// * get is O(1)
// Space Complexity: 
// The space required will be O((r * c)^2) in the worst case. 
// * O(r * c) space will be required for the Excel Form itself. 
// * For each cell in this form, the cells_where_in_formula list can contain O(r * c) cells.

class Cell {
    int row;
    String col;
    int val;
    List<String> cellsWhereInFormula;
    List<String> formula;

    public Cell(int row, String col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
        this.cellsWhereInFormula = new ArrayList<>();
        this.formula = null;
    }
}

public class Excel {
    private final Map<String, Cell> graph;

    public Excel(int height, char width) {
        graph = new HashMap<>();
        for (int row = 1; row <= height; row++) {
            for (char col = 'A'; col <= width; col++) {
                String cellId = row + String.valueOf(col);
                graph.put(cellId, new Cell(row, String.valueOf(col), 0));
            }
        }
    }

    public void set(int row, char column, int val) {
        String cellId = String.valueOf(row) + column;
        Cell cell = graph.get(cellId);

        // Remove cell formula as it is being replaced by a value. 
        // Also remove any cells that were reporting its value to formula
        if (cell.formula != null) {
            List<String> formulaCells = getCellsFromFormula(cell.formula);
            for (String dependency : formulaCells) {
                graph.get(dependency).cellsWhereInFormula.remove(cellId);
            }
            cell.formula = null;
        }

        // Update value of cells where this cell is in formula
        updateCellsWhereInFormula(cell, cell.val, val);

        // Set value
        cell.val = val;
    }

    public int get(int row, char column) {
        String cellId = String.valueOf(row) + column;
        return graph.get(cellId).val;
    }

    public int sum(int row, char column, String[] numbers) {
        String cellId = String.valueOf(row) + column;
        Cell cell = graph.get(cellId);

        // Remove cell formula as it is being replaced by a new formula. 
        // Also remove any cells that were reporting its value to formula
        if (cell.formula != null) {
            List<String> oldDeps = getCellsFromFormula(cell.formula);
            for (String dep : oldDeps) {
                graph.get(dep).cellsWhereInFormula.remove(cellId);
            }
        }

        // Set new formula and add this cell id to cells that are in this formula
        cell.formula = Arrays.asList(numbers);
        List<String> newDeps = getCellsFromFormula(Arrays.asList(numbers));
        int oldVal = cell.val;
        cell.val = 0;

        for (String dep : newDeps) {
            graph.get(dep).cellsWhereInFormula.add(cellId);
            cell.val += graph.get(dep).val;
        }

        // Update value of cells where this cell is in formula
        updateCellsWhereInFormula(cell, oldVal, cell.val);
        return cell.val;
    }

    private List<String> getCellsFromFormula(List<String> formula) {
        List<String> cells = new ArrayList<>();
        for (String element : formula) {
            if (!element.contains(":")) {
                // Single cell like "A1" -> transform to "1A"
                String col = element.replaceAll("[0-9]", "");
                String row = element.replaceAll("[^0-9]", "");
                cells.add(row + col);
            } else {
                String[] parts = element.split(":");
                String start = parts[0];
                String end = parts[1];
                char startCol = start.charAt(0);
                int startRow = Integer.parseInt(start.substring(1));
                char endCol = end.charAt(0);
                int endRow = Integer.parseInt(end.substring(1));

                for (int row = startRow; row <= endRow; row++) {
                    for (char col = startCol; col <= endCol; col++) {
                        cells.add(row + String.valueOf(col));
                    }
                }
            }
        }
        return cells;
    }

    private void updateCellsWhereInFormula(Cell cell, int oldVal, int newVal) {
        for (String dependentId : cell.cellsWhereInFormula) {
            Cell dependent = graph.get(dependentId);
            int dependentOldVal = dependent.val;
            dependent.val = dependent.val - oldVal + newVal;
            updateCellsWhereInFormula(dependent, dependentOldVal, dependent.val);
        }
    }
}


/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */
