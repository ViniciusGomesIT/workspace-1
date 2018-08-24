import java.io.File;

public class Diretorios {

    public void listar(File directory) {
        if(directory.isDirectory()) {
        	if (directory.getPath().contains("src\\main\\java")) {
        		System.out.println(directory.getPath());
        	}            
            String[] subDirectory = directory.list();
            
            if(subDirectory != null) {
                for(String dir : subDirectory){
                    listar(new File(directory + File.separator  + dir));
                }
            }
        }
    }


    public static void main(String x[]) {
        Diretorios dir = new Diretorios();
        dir.listar(new File("E:\\WorkSpace Java\\workspace-1\\"));
    }
}