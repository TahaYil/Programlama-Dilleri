import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bagli_Sirala {
    public static int sayiCevir(String kelime){
        return Integer.parseInt(kelime);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Dosya ismi giriniz : ");
        String dosya=scanner.nextLine();

        File f=new File("/Users/tahay/Documents/ProgramlamaDilleri/Odev2/Bagli_Sirala/src/"+dosya);
        if(!f.exists()){
            System.out.println("Bu isimde dosya bulunmamaktadır !!!!");
            return;
        }
        List<Bagli> ans=new ArrayList<>();
        try {
            BufferedReader reader=new BufferedReader(new FileReader(f));
            String satir="";
            int sayac=1;
            while((satir= reader.readLine())!=null){
                int sayi=sayiCevir(satir);
                ans.add(new Bagli(sayi,sayac));

                sayac++;
            }
            ans.get(ans.size()-1).pointer=-1;

            for(Bagli a:ans){
                System.out.println("sayi : " + a.sayi + " pointer : "+a.pointer);
            }
            Bagli t1=ans.get(0);
            while (t1.pointer!=-1){
                Bagli t2=ans.get(t1.pointer);
                while (true){
                    if(t2.sayi< t1.sayi){
                        int temp=t1.sayi;
                        t1.sayi= t2.sayi;
                        t2.sayi=temp;
                        t2=ans.get(t1.pointer);
                    }
                    if(t2.pointer==-1)break;
                    t2=ans.get(t2.pointer);
                }
                t1=ans.get(t1.pointer);
            }
            System.out.println("************************");
            System.out.println("*********************");
            for(Bagli a:ans){
                System.out.println("sayi : " + a.sayi + " pointer : "+a.pointer);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}