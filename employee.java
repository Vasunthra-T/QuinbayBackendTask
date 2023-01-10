import java.io.*;
import java.util.*;
import java.lang.String;
class employee{
public static int getFileColumnsNumber(String filename) {
    File file = new File(filename);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }

        int number = 0;
        if (scanner.hasNextLine()) {
            number = scanner.nextLine().split(",").length;
        }
        scanner.close();
        return number;
    }
    public static int getFileRowsNumber(String filename) {
        int count = 0;
        File file = new File(filename);
        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }

            sc.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
        return count;
    }
    public static int splitFile(String strings[][])
    {
        int j=5;
        for(int i=1;i<50;i++){
        if(strings[i][j].equals("DEV"))
        {
            try {
                for(int k=1;k<6;k++) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/vasunthra/Documents/dev.txt",true));
                    writer.append(strings[i][k]);
                    writer.close();
                    System.out.println("Successfully wrote to the file.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else if(strings[i][j].equals("QA"))
            {
                try {
                    for(int k=1;k<6;k++) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/vasunthra/Documents/qa.txt",true));
                        writer.append(strings[i][k]);
                        writer.close();
                        System.out.println("Successfully wrote to the file.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
    }
    return 0;
    }

    public static void main(String[] args)throws IOException{
        String filename = "/Users/vasunthra/Downloads/employees.txt";
        System.out.println(getFileColumnsNumber(filename));
        System.out.println(getFileRowsNumber(filename));

        /*Scanner sc = new Scanner(filename);
        int rows = 6;
        int columns = 51;
        int [][] myArray = new int[rows][columns];
        while(sc.hasNextLine()) {
            for (int i=0; i<myArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    myArray[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(myArray));*/


        BufferedReader br = new BufferedReader(new FileReader(filename));
        List lines = new ArrayList();
        for(String line = br.readLine();line != null;line = br.readLine()) {
            // split by comma
            String[] fields = line.split(",");
            lines.add(fields);
        }
        String[][] strings = (String[][]) lines.toArray(new String[lines.size()][]);
        System.out.println("Lines="+strings.length);
        System.out.println(splitFile(strings));

        for(int i=1;i<50;i++){
            for(int j=1;j<2;j++){
                strings[i][j] = strings[i][j]+strings[i][j+1];
                System.out.println(strings[i][j]);
            }
        }


        /*FileWriter myWriter = new FileWriter("/Users/vasunthra/Documents/dev.txt");
        myWriter.write("Hello");*/



    }
}
/Users/vasunthra/IdeaProjects/assessment_employee/src/employee.java