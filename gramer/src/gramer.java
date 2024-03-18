import java.util.*;

public class gramer {
    static boolean dogru=true;
    static String[] ozneler = {"Ben" , "Sen" , "Hasan" , "Nurşah" , "Elif" , "Abdulrezzak" , "Şehribanu" , "Zeynelabidin" , "Naki"};
    static String[] nesneler = {"Bahçe" , "Okul" , "Park" , "Sınıf" , "Yarın" , "Pazartesi" , "Salı" , "Çarşamba" , "Perşembe" , "Cuma" , "Cumartesi" , "Pazar" , "Merkez" , "Ev" , "Kitap" , "Defter" , "Güneş" , "Beydağı"};
    static String[] yuklemler = {"Gitmek" , "Gelmek" , "Okumak" , "Yazmak" , "Yürümek" , "Görmek"};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Cümleyi giriniz : ");
        String cumle=scanner.nextLine();
        String[] dizi =kelimelereAyir(cumle);

        if(!ozneMi(dizi[0]))dogru=false;
        //System.out.println(dogru);
        if(!nesneMi(dizi[1]))dogru=false;

        if(!yuklemMi(dizi[2]))dogru=false;
        //System.out.println(dogru);
        if(dogru) System.out.println("Cümle doğrudur .");
        else System.out.println("Cümle yanlıştır .");

    }
    static boolean ozneMi(String kelime){
        if(kelime==null)return false;
        for ( int i = 0 ;i < ozneler.length ; i++){
            if(kelime.equals(ozneler[i]))return true;
        }
        return false;
    }
    static boolean nesneMi(String kelime){
        if(kelime==null)return false;
        for ( int i = 0 ;i < nesneler.length ; i++){
            if(kelime.equals(nesneler[i]))return true;
        }
        return false;
    }
    static boolean yuklemMi(String kelime){
        if(kelime==null)return false;
        for ( int i = 0 ;i < yuklemler.length ; i++){
            if(kelime.equals(yuklemler[i]))return true;
        }
        return false;
    }
    static String[] kelimelereAyir(String cumle){
        String[] dizi=new String[3];
        int i=0;
        String kelime ="";
        int es=0;
        char harf;
        while(i<cumle.length()){
            harf=cumle.charAt(i);
            if(!Character.isLetter(harf))i++;
            else{
                while(i<cumle.length()&&cumle.charAt(i)!=' '){

                    kelime+=cumle.charAt(i);
                    i++;

                    //harf=cumle.charAt(i);
                }
                if(es==3)dogru=false;
                else {
                    dizi[es] = kelime;
                    es++;
                    //i++;
                    kelime = "";
                }

            }


        }
        return dizi;
    }
}