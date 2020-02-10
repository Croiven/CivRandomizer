package civRandom;

import fi.jyu.mit.fxgui.Dialogs;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Joonas
 * @version 3.3.2018
 * Ohjelma arpoo 1-8 pelaajalle kaksi kansaa Sid Meier's Civilization VI peliin.
 * T�m� tiedosto on javaFX:ll� toteutetun ohjelman controlleri.
 */
public class CivRandomController {
	
	
	@FXML
	private ToggleGroup ButtonAll;
	
	@FXML
    private TextField TextFieldPelaaja1;

    @FXML
    private TextField TextFieldPelaaja2;

    @FXML
    private TextField TextFieldPelaaja3;

    @FXML
    private TextField TextFieldPelaaja4;

    @FXML
    private TextField TextFieldPelaaja5;

    @FXML
    private TextField TextFieldPelaaja6;

    @FXML
    private TextField TextFieldPelaaja7;

    @FXML
    private TextField TextFieldPelaaja8;
    
    
    @FXML
    void handleArvo() {
    	arvo();
    }
    
   
    private String[] kaikki = {"Teddy Roosevelt", "Saladin", "John Curtin","Montezuma","Pedro II","Qin Shi Huang","Poundmaker","Wilhelmina", "Cleopatra",
                               "Victoria", "Catherine de Medici","Tamar","Frederick Barbarossa","Pericles","Gorgo","Gandhi", "Chandragupta","Gitarja",
                               "Hojo Tokimune","Jayavarman VII","Mvemba a Nzinga","Seondeok","Alexander", "Lautaro","Genghis Khan","Harald Hardrada",
                               "Amanitore","Cyrus","Jadwiga","Trajan","Peter","Robert the Bruce","Tomyris","Philip II","Gilgamesh","Shaka","Matthias Corvinus",
                               "Kupe", "Wilfrid Laurier", "Pachacuti", "Mansa Musa", "Kristina", "Suleiman", "Dido", "Eleanor(E)", "Eleanor(F)"};
    
    private String[] RF = {"Poundmaker", "Wilhelmina", "Tamar", "Chandragupta", "Seondeok", "Lautaro", "Genghis Khan", "Robert the Bruce", "Shaka"};
    
    private int maxKaikki = kaikki.length - 1;


    private int maxRF = RF.length - 1;
    
	int[] kaikkiRandom = {};

    Random randomNum = new Random();
    
    int[] arvotut = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
    int[] arvotut2 = {0,1,2,99,4,5,6,7};
	/**
	 * 
	 */
	public static final Random gen = new Random();  
	/**
	 * Aliohjelma joka arpoo lukuja v�lille 1-maxRange niin, ett� sama luku ei toistu. Kopioitu aliohjelma.
	 * @param n on m��r� montako arvotaan.
	 * @param maxRange maksimi arvolle.
	 * @return palauttaa taulukon arvottuja lukuja.
	 */
	public static int[] printRandomNumbers(int n, int maxRange) {  
	    assert n <= maxRange : "cannot get more unique numbers than the size of the range";  
	      
	    int[] result = new int[n];  
	    Set<Integer> used = new HashSet<Integer>();  
	      
	    for (int i = 0; i < n; i++) {  
	          
	        int newRandom;  
	        do {  
	            newRandom = gen.nextInt(maxRange+1);  
	        } while (used.contains(newRandom));  
	        result[i] = newRandom;  
	        used.add(newRandom);  
	    }  
	    return result;  
	}  
	
	/**
	 * Arpoo kaikista pelin kansoista.
	 */
	public void arvontaKaikki() {  
	    int v = 0;  
	    
	    for (int i : printRandomNumbers(16,maxKaikki)) {  
	        //System.out.println(i);
	        arvotut[v] = i; v++;
	    } 
	    
	}
	
	/**
	 * Arpoo ainoastaan Rise and Fall lis�osan kansoista.
	 */
	public void arvontaRF() {  
	    int t = 0;  
	    
	    for (int h : printRandomNumbers(8,maxRF)) {  
	        //System.out.println(i);
	        arvotut2[t] = h; t++;
	    } 
	    
	}
    
    
    /**
     * Aliohjelma suorittaa toiminnat kun painetaan "arvo" nappia.
     * Sis�lt�� tulostuksen.
     */
    private void arvo() {
    	arvontaKaikki();
    	arvontaRF();
        RadioButton rb = (RadioButton)ButtonAll.getSelectedToggle();
        if ( rb == null ) return;
        String id = rb.getId();
        String[] pelaajat = {TextFieldPelaaja1.getText(),TextFieldPelaaja2.getText(),TextFieldPelaaja3.getText(),TextFieldPelaaja4.getText(),TextFieldPelaaja5.getText(),TextFieldPelaaja6.getText(),TextFieldPelaaja7.getText(),TextFieldPelaaja8.getText(),};
        int j = Integer.parseInt(id.substring(2));
        if (j == 0) {

        	String palautus = "";
        	for (int i = 0; i < 8; i++) {
        	    if (pelaajat[i].length() != 0) {
        	    palautus += pelaajat[i] + ": " + kaikki[arvotut[i]] + " tai " + kaikki[arvotut[i+8]] + "\n" + "\n";
        	    }
        	}
        	Dialogs.showMessageDialog(palautus);
        	
        }
        if (j == 1) {

        	String palautus2 = "";
        	for(int k = 0; k < 4; k++) {
        	    if (pelaajat[k].length() != 0) {
        	        palautus2 += pelaajat[k] + ": " + RF[arvotut2[k]] + " tai " + RF[arvotut2[k+4]] + "\n" + "\n";
        	    }
        	}
        		
        	Dialogs.showMessageDialog(palautus2);
        }
    	
    
    
    
    }

}