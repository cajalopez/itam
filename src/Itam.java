import com.sun.xml.internal.bind.v2.TODO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;

public class Itam {


    public static void main(String[] argv) throws Exception {

        // Variable de entrada
        String mainPath = "/Users/cajalopez/Desktop/Itam/Entrada";
        String mainExtension = ".log";

        /*
        RAFAEL
        Construir una version que lea linea por linea un archivo de excel xlsx
        */

        // Entrada de ruta de directorio a evaluar
        File file = new File(mainPath);

        // Filtro de archivos.
        FilenameFilter filenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(mainExtension)){
                    return true;
                } else {
                    return false;
                }
            }
        };

        // Salida Inicial.
        String[] list = file.list(filenameFilter);
        System.out.println(list.length);
        for(String f:list){

            //System.out.println(f);
            File fileAux=new File(mainPath+"/"+f);
            FileReader fr=new FileReader(fileAux);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();
            //constructs a string buffer with no characters
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
            }
            fr.close();    //closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());
        }

    }

}
