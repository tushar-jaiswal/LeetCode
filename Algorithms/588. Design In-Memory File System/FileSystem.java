//Author: Tushar Jaiswal
//Creation Date: 11/30/2020

/*Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.

Example:
Input:
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]

Output:
[null,[],null,null,["a"],"hello"]

Note:
    You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
    You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
    You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.
*/

/*Runtime Complexity:
    ls is O(length of file path + klog(k)) where k is the number of entries in the last level directory of the input path.
    mkdir, addContentToFile, and readContentFromFile are O(length of file path).
Space Complexity: O(number of directories and file)*/

class FileSystem {

    File root;

    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        String[] directories = path.split("/");
        File curr = root;
        List<String> result = new ArrayList<String>();
        String name = "";

        for (String directory : directories) {
            if (directory.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(directory)) {
                curr.children.put(directory, new File());
            }
            curr = curr.children.get(directory);
            name = directory;
        }

        if (curr.isFile) {
            result.add(name);
        } else {
            for (String fileName : curr.children.keySet()) {
                result.add(fileName);
            }
        }

        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        String[] directories = path.split("/");
        File curr = root;

        for (String directory : directories) {
            if (directory.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(directory)) {
                curr.children.put(directory, new File());
            }
            curr = curr.children.get(directory);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] directories = filePath.split("/");
        File curr = root;

        for (String directory : directories) {
            if (directory.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(directory)) {
                curr.children.put(directory, new File());
            }
            curr = curr.children.get(directory);
        }

        curr.isFile = true;
        curr.contents += content;
    }

    public String readContentFromFile(String filePath) {
        String[] directories = filePath.split("/");
        File curr = root;

        for (String directory : directories) {
            if (directory.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(directory)) {
                curr.children.put(directory, new File());
            }
            curr = curr.children.get(directory);
        }
        return curr.contents;
    }
}

class File {
    boolean isFile = false;
    String contents = "";
    HashMap<String, File> children = new HashMap<String, File>();
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
