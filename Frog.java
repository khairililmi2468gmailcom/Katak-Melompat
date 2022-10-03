/**
 * Ini adalah program geme Frog/Katak melompat 
 * pada geme ini memiliki beberapa fungsi
 * Program akan meminta user untuk memiliih level yang diinginkan 
 * setelah itu akan mengarahkan user menuju permainan yang dimana
 * di dalam permainan, user dapat memerintahkan katak untuk 
 * maju dan mundur baik 2 atau 1 langkah
 * program ini real dibuat oleh:
 * @author Khairil Ilmi
 */


import java.util.Random;
import java.util.Scanner;

public class Frog {

        // fungsi main untuk run program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        proses();
        input.close();
    }
    // memberikan angka random, dibuat dengan cara membuat fungsi
    public static int randomNumber() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3);
        return randomNum;
    }
    // untuk memberi nilai damage monster per level atau memberi damage monster yang berbeda setiap levelnya
    static int resultMonster(int monster){
        if(monster == 25){
             monster = 5;
        } else if(monster == 100){
             monster = 10;
        } else if(monster == 500){
            monster = 15;
        }else {
            monster = 20;
        }
        return monster ; 
    }
    // memberi coin dari level ke level atau memberi nilai coin yang berbeda setiap levelnya
    static int resultCoin(int coin){
        if(coin == 25){
            coin = 20;
       } else if(coin == 100){
            coin = 15;
       } else if(coin == 500){
           coin = 10;
       }else {
           coin = 20;
       }
       return coin ; 
    }
    // memberi bonus health dari level ke level
    static int resultBonusHealth(int health){
        if(health == 25){
            health = 1;
       } else if(health == 100){
            health = 0;
       } else if(health == 500){
           health = 0;
       }else {
           health = 1;
       }
       return health ; 
    }

    // fungsi run untuk run program dimana ketika di run akan memberikan parameter bertipe int
    static void run(int level){
        Scanner input = new Scanner(System.in);//scan input
        int[] sumKotak = new int[500];
        int skor = 0;
        int nyawa = 100;
        int posisi = 1;
       
        for (int i = 0; i < sumKotak.length; i++) {
            petunjuk();
            try {
                for (int j = 0; j < 500;j++) {
                    System.out.print("\n(<-- mundur | manju --> ) : ");
                    char getInputMJ = input.next().charAt(0);

                    if (getInputMJ == 'w' || getInputMJ == 'W') {
                        System.out.println("Katak maju 1 Langkah");
                        posisi += 1;
                        sumKotak[posisi] = randomNumber();
                        j += 1;

                        // kondisi yang akan diberi level\
                        // katak akan berkurang banyak health jika terkena monster yang kuat di level glory
                        if (sumKotak[posisi] == 1) {
                            skor += 0;
                            nyawa -= resultMonster(level);
                            System.out.println("Health Berkurang: " + resultMonster(level));
                        } else if (sumKotak[posisi] == 2) {
                            skor += resultCoin(level);
                            nyawa += resultBonusHealth(level);
                            System.out.println("Skor bertambah menjadi : " + skor);
                            System.out.println("Health bertambah: " + nyawa);
                        } else {
                            skor += 1;
                            nyawa += 0;
                            System.out.println("Skor bertambah menjadi : " + skor);
                        }
                        
                        //  batas nya 

                        if(nyawa > 0){
                            System.out.println("Health: " + nyawa);
                        }
                        System.out.println("Total Skor: " + skor);
                        System.out.println("Katak berada di posisi ke- " + j);
                        if (nyawa < 0 || posisi == 499) {
                            System.out.println("Health : 0");
                            System.out.println("Game Over");
                            System.out.println("Skor Perolehan: " + skor);
                            // mendapatkan nilai
                            if(skor < 250){
                                System.out.println("bad");
                            } else if(skor < 500){
                                System.out.println("Good");
                            } else if(skor <= 1000){
                                System.out.println("Excelent");
                            }  else {
                                System.out.println("over");
                            }      
                            break;
                        }
                    } else if (getInputMJ == 'x' || getInputMJ == 'X') {
                        System.out.println("Katak mundur 1 Langkah");
                        posisi -= 1;
                        sumKotak[posisi] = randomNumber();
                        j -= 1;
                        while (posisi < 0) {
                            System.out.println("Tidak bisa mundur lagi");
                            break;
                        }
                        if (sumKotak[posisi] == 1) {
                            skor += 0;
                            nyawa -= resultMonster(level);
                            System.out.println("Health Berkurang: " + nyawa);
                        } else if (sumKotak[posisi] == 2) {
                            skor += resultCoin(level);
                            nyawa += resultBonusHealth(level);
                            System.out.println("Skor bertambah menjadi : " + skor);
                        } else {
                            skor += 1;
                            nyawa += 0;
                        }

                        if(nyawa > 0){
                            System.out.println("Health: " + nyawa);
                        }
                        System.out.println("Skor: " + skor);
                        if (j < 0) {
                            System.out.println("Uppss...Tidak bisa mundur lagi kawan !!!");
                        }
                        if (j >= 0 || j == 499) {
                            System.out.println("Katak berada di posisi ke- " + j);
                            if (nyawa < 0 || posisi == 499) {
                                System.out.println("Health : 0");
                                System.out.println("Game Over");
                                System.out.println("Skor Perolehan: " + skor);
                                if(skor < 250){
                                    System.out.println("bad");
                                } else if(skor < 500){
                                    System.out.println("Good");
                                } else if(skor <= 1000){
                                    System.out.println("Excelent");
                                }  else {
                                    System.out.println("over");
                                }      
                                break;     
                            }
                    }
                    } else if (getInputMJ == 'd' || getInputMJ == 'D') {
                        System.out.println("Katak Maju 2 Langkah");
                        posisi += 2;
                        sumKotak[posisi] = randomNumber();
                        j += 2;
                        while (posisi < 0) {
                            System.out.println("Tidak bisa mundur lagi");
                            break;
                        }
                        if (sumKotak[posisi] == 1) {
                            skor += 0;
                            nyawa -= resultMonster(level);
                            System.out.println("Health Berkurang: " + resultMonster(level));
                        } else if (sumKotak[posisi] == 2) {
                            skor += resultCoin(level);
                            nyawa += resultBonusHealth(level);
                            System.out.println("Skor bertambah menjadi : " + skor);
                        } else {
                            skor += 1;
                            nyawa += 0;
                        }
                        
                        if(nyawa > 0){
                            System.out.println("Health: " + nyawa);
                        }
                        System.out.println("Skor: " + skor);
                        System.out.println("Katak berada di posisi ke- " + j);
                        if (nyawa < 0 || posisi == 499) {
                            System.out.println("Health : 0");
                            System.out.println("Game Over");
                            System.out.println("Skor Perolehan: " + skor);
                            if(skor < 250){
                                System.out.println("bad");
                            } else if(skor < 500){
                                System.out.println("Good");
                            } else if(skor <= 1000){
                                System.out.println("Excelent");
                            }  else {
                                System.out.println("over");
                            }      
                            break;    
                        }  
                    
                    } else if (getInputMJ == 'a' || getInputMJ == 'A') {
                        System.out.println("Katak Mundur 2 Langkah");
                        posisi -= 2;
                        sumKotak[posisi] = randomNumber();
                        j -= 2;
                        while (posisi < 0) {
                            System.out.println("Tidak bisa mundur lagi");
                            break;
                        }
                        if (sumKotak[posisi] == 1) {
                            skor += 0;
                            nyawa -= resultMonster(level);
                            System.out.println("Health Berkurang: " + resultMonster(level));
                        } else if (sumKotak[posisi] == 2) {
                            skor += resultCoin(level);
                            nyawa += resultBonusHealth(level);
                            System.out.println("Skor bertambah menjadi menjadi : " + skor);
                        } else {
                            skor += 1;
                            nyawa += 0;
                        }
                        if(nyawa > 0){
                            System.out.println("Health: " + nyawa);
                        }
                        System.out.println("Skor: " + skor);
                        if (j >= 0) {
                            System.out.println("Katak berada di posisi ke- " + j);
                        }
                        if (j < 0) {
                            System.out.println("Uppss...Tidak bisa mundur lagi kawan !!!");
                        }
                        if (nyawa < 0 || posisi == 499) {
                            System.out.println("Health: 0");
                            System.out.println("Game Over");
                            System.out.println("Skor Perolehan: " + skor);
                            if(skor < 250){
                                System.out.println("bad");
                            } else if(skor < 500){
                                System.out.println("Good");
                            } else if(skor <= 1000){
                                System.out.println("Excelent");
                            }  else {
                                System.out.println("over");
                            }      
                            System.out.println("...........................................");
                            break; 
                        }
                    } else {
                        System.out.println("Jangan lupa ya!!!");
                        petunjuk();
                        break;
                    }
                 
                }
            } catch (Exception e) {
                // jika tidak menginput w, x, a, dan d untuk mengubah gerak  
                System.out.println("\n=========================================");
                System.out.println("Tekan (w / W)");
                System.out.println("Tolong, Masukkan 'w'/'a' atau 'x'/'d'");
                System.out.println("Start harus maju dahulu ");
                System.out.println("Tidak boleh kurang dari posisi awal 0");
                System.out.println("Enter untuk keluar");
                System.out.println("=========================================");
                enter();
                clearScreen();
                break;
            }
            
            System.out.print("\nApakah anda ingin melanjutkan (y/n): ");
            char ulangi = input.next().charAt(0);
            do {
                if(ulangi == 'y' || ulangi == 'Y'){
                    
                    i = sumKotak.length;
                    return ;
                } else {
                    System.out.print("Enter!!!\n");
                    enter();
                    clearScreen(); // jika tidak ingin diulangi
                }
            } while (ulangi !='y' || ulangi != 'Y' || ulangi != 'n' || ulangi != 'N');
                 
            input.close();
    }
    return;
}

    static void proses(){
        Scanner input = new Scanner(System.in);
        
        int pilihLevel;
        int level;
        try{
        // memerintahkan user untuk menginput level yang ingin dipilih
        System.out.println("Welcome in Mobile Katak");
        System.out.println("1. Warior");
        System.out.println("2. Grand");
        System.out.println("3. Gloary");
        System.out.print("pilih level: ");
        pilihLevel = input.nextInt();
            switch (pilihLevel) {
                //  jika pilihan 1 atau Warior
                case 1:
                    level = 25;                     
                    run(level);
                    System.out.println("Anda telah menyelesaikan geme level warior");
                case 2:
                    level = 100;
                    run(level);        
                    System.out.println("Wah....Anda telah menyelesaikan geme level Grand");
                
                case 3:
                    level = 500;
                    run(level);
                    System.out.println("Keren banget ah, Anda telah menyelesaikan geme level Gloary");
                default:
                    level = 25;
                    run(level);
                    System.out.println("Anda telah menyelesaikan geme level warior");
            }
        } catch (Exception e){
            // jika user tidak menginput angka 1,2 dan 3 
            // maka program akan menampilkan perintah berikut
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("\t\tMasukkan pilihan 1,2,3 untuk pilih level yang anda inginkan");
            System.out.println("\t\tMaaf harus keluar terlebih dahulu");
            System.out.println("\t\tTerima kasih telah bermain game Frog kami");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
        
        input.close();
}

    public static void petunjuk() {
        System.out.println(" -------------------------------------");
        System.out.println("|  Petunjuk :                         |");
        System.out.println("|  1. Maju = Tekan 'w'                |");
        System.out.println("|  2. Mundur = Tekan 'x'              |");
        System.out.println("|  3. Tekan 'd' (jika maju 2x)    |");
        System.out.println("|  4. Tekan 'a' (jika mundur 2x)  |");
        System.out.println(" -------------------------------------");
        System.out.println("JIKA INGIN ULANGI TEKAN Y/N!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    static void enter() {
        Scanner enter = new Scanner(System.in);
        enter.nextLine();
        enter.close();
    }

    static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception e) {
            System.err.println("Tidak bisa clear screen");
        }
    }
}