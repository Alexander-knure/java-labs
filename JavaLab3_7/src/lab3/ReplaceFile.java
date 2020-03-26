package lab3;
import java.io.*;
import java.util.*;

public class ReplaceFile {
    private File fname;
    private Scanner in;
    private String sub1;
    private String sub2;
    private ArrayList<String> content;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public ReplaceFile(String name)
    {
        fname = new File(name);
        in = new Scanner(System.in);
        content = new ArrayList<String>();
    }

    private void inputSubstrings()
    {
        System.out.println("Input first substring which in the file");
        sub1 = in.nextLine();;
        System.out.println("Input second substring to replace");
        sub2 = in.nextLine();;
    }

    public void setSubstrings()
    {
        inputSubstrings();
        int i;
        for(i= 0; i < content.size();i++)
        {
           String sub = content.get(i).replace(sub1, sub2);
           content.set(i, sub);
        }
        System.out.printf("Replaced %d substrings\n", i);
        StringBuilder sb = new StringBuilder();
        for (String it: content)
            sb.append(it);

        write(sb.toString());
    }

    public void write(String text)
    {
        try(FileOutputStream fos = new FileOutputStream(fname))
        {
            // перевод строки в байты
            byte[] buffer = text.getBytes();

            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("The file \"" + fname.getName() + "\" has been written");
    }

    public void read()
    {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try
        {
            fis = new FileInputStream(fname);
            isr = new InputStreamReader(fis,"UTF-8");
            int i = 0; //integer > byte
            boolean flag = false;
            StringBuilder word = new StringBuilder();

            while((i=isr.read()) != -1){
                if((char)i == ' ' || (char)i == ','|| (char)i == ';'|| (char)i == ':'|| (char)i == '.')
                {
                    content.add(word.toString());
                    flag = true;
                    word.setLength(0);
                    content.add(Character.toString((char)i));

                    System.out.print((char)i);
                }
                else
                {
                    if(flag == true)
                    {
                        flag = false;
                        word.setLength(0);
                    }

                    word.append(Character.toString((char)i));
                    System.out.print((char)i);
                }
            }
            System.out.println();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The file \"" + fname.getName() + "\" has been read");
    }

    public void readCollection() {
        for(String a:content)
            System.out.print( ANSI_GREEN + "\'" + a + "\'" + ANSI_RESET + "|");
        
        System.out.println();
    }
}