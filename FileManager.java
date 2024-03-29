import java.nio.file.*;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in);
while (true)
 { 
 displayMenu();

int choice = scanner.nextInt();
scanner.nextLine(); 

switch (choice) {

case 1:
createFile(scanner);
break;

case 2:
createDirectory(scanner);
break;

case 3:
deleteFileOrDirectory(scanner);
break;

case 4:
copyFile(scanner);
break;

case 5:
moveFile(scanner);
break;

case 6:
listFilesAndDirectories();
break;

case 7:
System.out.println("Exiting the program. Goodbye!");
System.exit(0);

default:
System.out.println("Invalid choice. Please enter a valid option.");

    }
  }
}

private static void displayMenu()
 {

System.out.println("\nFile Manager Menu:");
System.out.println("1. Create File");
System.out.println("2. Create Directory");
System.out.println("3. Delete File or Directory");
System.out.println("4. Copy File");
System.out.println("5. Move File");
System.out.println("6. List Files and Directories");
System.out.println("7. Exit");
System.out.print("Enter your choice: ");

}

private static void createFile(Scanner scanner ) {

System.out.print("Enter the file name: ");
String fileName = scanner.nextLine();

try {

Files.createFile(Paths.get(fileName));
System.out.println("File created successfully.");
}
catch (IOException e)
 {

 System.out.println("Error creating file: " +e.getMessage());

}

}

private static void createDirectory(Scanner scanner) {

System.out.print("Enter the directory name: ");

String dirName = scanner.nextLine();

try {

Files.createDirectory(Paths.get(dirName));

System.out.println("Directory created successfully.");

}
 catch (IOException e) 
 {

System.out.println("Error creating directory: " + e.getMessage());

}
}

private static void deleteFileOrDirectory(Scanner scanner)
 {

System.out.print("Enter the path of the file or directory to delete: ");

String path = scanner.nextLine();

try {

Files.delete(Paths.get(path));

System.out.println("File or directory deleted successfully.");

} 
catch (IOException e) 
{

System.out.println("Error deleting file or directory: " + e.getMessage());

}
}
private static void copyFile(Scanner scanner)
{ 

System.out.print("Enter the source file path: ");
String sourcePath = scanner.nextLine();
System.out.print("Enter the destination file path: ");
String destinationPath = scanner.nextLine();

try 
{

Files.copy(Paths.get(sourcePath), 
Paths.get(destinationPath),
StandardCopyOption.REPLACE_EXISTING);
System.out.println("File copied successfully."); 

} 
catch (IOException e) 
{

System.out.println("Error copying file: " + e.getMessage());

}
}

private static void moveFile(Scanner scanner)

{

System.out.print("Enter the source file path: ");

String sourcePath = scanner.nextLine();

System.out.print("Enter the destination file path: ");

String destinationPath = scanner.nextLine();

try {

Files.move(Paths.get(sourcePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);

System.out.println("File moved successfully."); 
}
 catch (IOException e)
 {

System.out.println("Error moving file: " +e.getMessage());

}

}

private static void listFilesAndDirectories()
 {
System.out.print("Enter the directory path: ");
Scanner scanner = new Scanner(System.in);
String dirPath = scanner.nextLine();

try 
(DirectoryStream<Path> directoryStream  = Files.newDirectoryStream (Paths.get(dirPath)))
 {

System.out.println("Files and Directories in " + dirPath + ":");

for (Path path: directoryStream)
 {

System.out.println(path.getFileName());

}

} 
catch (IOException e)
 {
System.out.println("Error listing files and directories: " + e.getMessage());
   }
 }
}