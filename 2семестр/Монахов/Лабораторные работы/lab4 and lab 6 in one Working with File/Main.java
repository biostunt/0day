

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main{
    public static String getContent() throws Exception{
            return new String(Files.readAllBytes(Paths.get("Source to book.txt")));
    }
    public static String readFile() throws Exception{
        return new String(Files.readAllBytes(Paths.get("")));
    }
    public static void println(String s ){
        System.out.println(s);
    }
    public static void print(String s){
        System.out.print(s);
    }
    public static void getElements(BST heapSearch){
        for(int i = 0; i < heapSearch.size();i++){
            System.out.println(heapSearch.get(heapSearch.select(i)) +
                    " key: " + heapSearch.select(i));
        }
    }

    @NotNull
    public static String putElements(BST heapSearch, char[] charContent){
        String tempWord = "";
        int line = 1,position = 1;
        for(int i = 0; i < charContent.length;i++){
            if(charContent[i] != '\n' && charContent[i] != ' ' && charContent[i] != ',' && charContent[i] != '.'&& charContent[i] != '_'
                    && charContent[i] != '+'&& charContent[i] != '='&& charContent[i] != '1'&& charContent[i] != '2'&& charContent[i] != '3'&& charContent[i] != '4'
                    && charContent[i] != '5'&& charContent[i] != '6'&& charContent[i] != '7'&& charContent[i] != '8'&& charContent[i] != '9'&& charContent[i] != '0'){
                tempWord += charContent[i];
            }
            if((charContent[i] == ' ' || charContent[i] == '\n') && tempWord != ""){
                if(tempWord != "") heapSearch.put(line*100000+position,tempWord);
                if(charContent[i] == ' ') position++;
                if(charContent[i] == '\n'){
                    line++;
                    position = 1;
                }
                tempWord = "";
            }
            if(tempWord != "") heapSearch.put(line*100000+position,tempWord);
        }
        return "adding successful!";
    }

    public static String getMenu(){
        return "\n1.Вывести элементы\n2.Найти элемент\n3.Выход\n";
    }


    public static void main(String[] args) throws Exception{
        BST heapSearch = new BST();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String content = getContent();
        char[] charContent = content.toCharArray();
        boolean isExit = false;
        int choice = 0;
        String required = null;
        System.out.println("" + putElements(heapSearch, charContent));
        while(isExit == false) {
            System.out.print(getMenu());
            choice = Integer.parseInt(input.readLine());
            if (choice == 1) getElements(heapSearch);
            if (choice == 2){
                System.out.print("Введите требуемое слово\n");
                required = input.readLine();
                int[] indexArr = new int[heapSearch.size()];
                int count = 0;
                for(int i = 0; i < heapSearch.size(); i++){
                    if(required.equalsIgnoreCase(heapSearch.get(heapSearch.select(i)).toString())){
                        indexArr[count] = i;
                        count++;
                    }
                }
                if(count > 0){
                    System.out.print("Элемент найден - встречается " + count + " раз." + " Позиция эл-та: \n");
                    for(int i = 0; i < count; i++){

                        int line = Integer.parseInt("" + heapSearch.select(indexArr[i]));
                        System.out.print("Строка в тексте - " + ((line / 100000)) + " Позиция в строке - " + (line % 100000) + "\n");

                    }
                }
                else System.out.println("Элементов не найдено");

            }
            if (choice == 3){
                isExit = true;
                heapSearch = null;
            }
        }
    }
}