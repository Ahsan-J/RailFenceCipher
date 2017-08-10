/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railfencecipher;

/**
 *
 * @author Xcalaiberz
 */
public class RailFenceCipher {

    /**
     * @param args the command line arguments
     */
    public static int key = 2;
    public static void main(String[] args) {
        String PlainText = "My name is Ahsan";
        String encryptedText = encrypt(PlainText);
        System.out.println(encryptedText);
        System.out.println("");
        System.out.println(decrypt(encryptedText));
    }
    public static String encrypt(String message){
        String encryptedText = new String();
        char matrix[][] = new char[key][message.length()];
        for(int i=0;i<key;i++){
            for(int j=0;j<message.length();j++){
                matrix[i][j]=0;
            }
        }
        for(int i=0;i<message.length();i++){
            matrix[i%key][i] = message.charAt(i);
        }
        for(int i=0;i<key;i++){
            for(int j=0;j<message.length();j++){
                if(matrix[i][j]!=0){
                    encryptedText = encryptedText + matrix[i][j];
                }
            }
        }
        return encryptedText;
    }
    public static String decrypt(String message){
        String decryptedText = new String();
        char matrix[][] = new char[key][message.length()];
        for(int i=0;i<key;i++){
            for(int j=0;j<message.length();j++){
                matrix[i][j]=0;
            }
        }
        int k=0;
        for(int i=0;i<key;i++){
            for(int j=0;j<message.length();j=j+key){
                if(k<message.length()){
                    matrix[i][j] = message.charAt(k++);
                }
            }
        }
        
        for(int j=0;j<message.length();j=j+key){
            for(int i=0;i<key;i++){
                if(matrix[i][j]!=0){
                    decryptedText = decryptedText + matrix[i][j];
                }
            }
        }
        return decryptedText;
    }
}