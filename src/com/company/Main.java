package com.company;
import java.util.*;

public class Main {
    public static void tri_selection(int[] tab)
    {
        for (int i = 0; i < tab.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < tab.length; j++)
            {
                if (tab[j] < tab[index]){
                    index = j;
                }
            }

            int min = tab[index];
            tab[index] = tab[i];
            tab[i] = min;
        }
    }
    public static void tri_insertion(int[] tab)
    {
        int taille = tab.length;

        for (int i = 1; i < taille; i++)
        {
            int index = tab[i];
            int j = i-1;

            while(j >= 0 && tab[j] > index)
            {
                tab[j+1] = tab[j];
                j--;
            }
            tab[j+1] = index;
        }
    }
    static void tri_rapid(int tab[] , int deb , int fin){
        if (deb < fin){
            int pivot = partition(tab , deb ,fin);
            tri_rapid(tab , deb , pivot-1);
            tri_rapid(tab , pivot+1 , fin);
        }}

    static int partition(int tab[] , int debut ,int fin){
        int pivot = tab[debut];
        int i , compteur = debut;
        for ( i = debut+1 ; i <=fin ; i++){
            if (tab[i]<pivot ){
                compteur +=1;
                changer(tab,compteur,i);
            }
        }
        changer(tab , debut , compteur);
        return compteur;

    }

    //méthode de permutation !!
    static void changer(int T1[] , int i  , int j){
        int temp ;
        temp = T1[i];
        T1[i] = T1[j];
        T1[j] = temp ;
    }
    static void tri_bulle(int[] tab)
    {
        int taille = tab.length;
        int tmp = 0;
        for(int i=0; i < taille; i++)
        {
            for(int j=1; j < (taille-i); j++)
            {
                if(tab[j-1] > tab[j])
                {
                    //echanges des elements
                    tmp = tab[j-1];
                    tab[j-1] = tab[j];
                    tab[j] = tmp;
                }

            }
        }
    }
    static void fusion(int tab[], int debut, int milieu, int fin) {
        int n1 = milieu - debut + 1;
        int n2 = fin - milieu;

        int G[] = new int[n1];
        int D[] = new int[n2];

        for (int i = 0; i < n1; i++)
            G[i] = tab[debut + i];
        for (int j = 0; j < n2; j++)
            D[j] = tab[milieu + 1 + j];

        // maintient trois pointeurs, un pour chacun des deux tableaux et un pour
        // maintenir l'index actuel du tableau trié final
        int i, j, k;
        i = 0;
        j = 0;
        k = debut;

        while (i < n1 && j < n2) {
            if (G[i] <= D[j]) {
                tab[k] = G[i];
                i++;
            } else {
                tab[k] = D[j];
                j++;
            }
            k++;
        }

        // Copiez tous les éléments restants du tableau non vide
        while (i < n1) {
            tab[k] = G[i];
            i++;
            k++;
        }

        while (j < n2) {
            tab[k] = D[j];
            j++;
            k++;
        }
    }

static  void tri_fusion(int tab[], int debut, int fin) {
        if (debut < fin) {

            // Trouvez le point milieu pour diviser le tableau en deux moitiés
            int m = (debut + fin) / 2;

            tri_fusion(tab, debut, m);
            tri_fusion(tab, m + 1, fin);

            // Fusionnez les deux moitiés triées
            fusion(tab, debut, m, fin);
        }
    }
    static void displayTab(int[] tab){
        for(int i=0; i < tab.length; i++)
        {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scanner= new Scanner(System.in);
        // length of the table determine by the user
        System.out.print("Enter the length of the table : ");
        int n= scanner.nextInt();
        // table of integers
        int[] table = new int [n];
        // read the values of the table by input
        for(int i=0;i<n;i++){
            System.out.println("Enter the value of the table number  " +i+" :");
            table[i]=scanner.nextInt();
        }
        System.out.println("**** Avant le tri  *****");
        displayTab(table);

      // tri du tableau
        //tri_selection(table);
       // tri_insertion(table);
       // tri_bulle(table);
        //tri_fusion(table,0,n-1);
        tri_rapid(table,0,n-1);

        System.out.println("**** Apres le tri ****");
        displayTab(table);
    }
}
