package com.tarikkilic.connectfour;



import java.util.Random;

/**
 * Created by tarik on 23.02.2018.
 */

public class Logic {
    private int arr[][];
    private int size;
    private int lastJ;
    public Logic(int s){
        size = s;
        arr = new int[size][size];

        for(int i = 0;i < size;i++){
            for(int j = 0; j < size;j++){
                arr[i][j] = 0;
            }
        }
    }



    public void setMavi(int x,int y){
        arr[x][y] = 1;
    }


    public void setSari(int x,int y){
        arr[x][y] = 2;
    }


    public int get(int x,int y){
        return arr[x][y];
    }

    int isFinishedMavi(){
        int status = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i + 1, j) == 1 && isLegal(i + 2, j) == 1 && isLegal(i + 3, j) == 1) {
                    if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 2][j] == 1 && arr[i + 3][j] == 1) {
                        status = 1;
                    }
                }
                if (isLegal(i, j + 1) == 1 && isLegal(i, j + 2) == 1 && isLegal(i, j + 3) == 1) {
                    if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1 && arr[i][j + 3] == 1) {
                        status = 1;
                    }
                }
            }
        }
        return  status;
    }



    /**
     *     Oyun Bitis Fonksiyonlari
     * Sag ve sol tarafi kontrol eder
     * @return Bitmis ise 1,yoksa 0
     **/
    int isFinishedSari(){
        int status = 0;
        for (int k = 0; k < size; ++k) {
            for (int l = 0; l < size; ++l) {
                if(isLegal(k+1,l) == 1 && isLegal(k+2,l) == 1 && isLegal(k+3,l) == 1) {
                    if (arr[k][l] == 2 && arr[k + 1][l] == 2 && arr[k + 2][l] == 2 && arr[k + 3][l] == 2) {
                        status = 2;
                    }
                }
                if(isLegal(k,l+1) == 1 && isLegal(k,l+2) == 1 && isLegal(k,l+3) == 1) {
                    if (arr[k][l] == 2 && arr[k][l + 1] == 2 && arr[k][l + 2] == 2 && arr[k][l + 3] == 2) {
                        status = 2;
                    }
                }
            }
        }
        return status;
    }


    /**
     * secilen yerin size in icinde olup olmamasini kontrol eder.
     * @param x Satir
     * @param y Sutun
     * @return
     */
    private  int isLegal(int x,int y){
        int status = 0;
        if(x >= 0 && y >= 0 && x < size && y < size)
            status = 1;

        return status;
    }





    /**
     *   Oyun Bitis Fonksiyonlari
     *   Capraz tarafi kontrol eder
     * @return Bitmis ise 1,yoksa 0
     **/
    int crossFinishedSari(){
        int status = 0;
        for (int k = 0; k < size; ++k) {
            for (int l = 0; l < size; ++l) {
                if(isLegal(k+1,l+1) == 1 && isLegal(k+2,l+2) == 1 && isLegal(k+3,l+3) == 1){
                    if(arr[k][l] == 2 && arr[k+1][l+1] == 2 && arr[k+2][l+2] == 2 && arr[k+3][l+3] == 2) {
                        status = 2;
                    }
                }
                if(isLegal(k-1,l+1) == 1 && isLegal(k-2,l+2) == 1 && isLegal(k-3,l+3) == 1){
                    if(arr[k][l] == 2 && arr[k-1][l+1] == 2 && arr[k-2][l+2] == 2 && arr[k-3][l+3] == 2) {
                        status = 2;
                    }
                }
                if(isLegal(k+1,l-1) == 1 && isLegal(k+2,l-2) == 1 && isLegal(k+3,l-3) == 1){
                    if(arr[k][l] == 2 && arr[k+1][l-1] == 2 && arr[k+2][l-2] == 2 && arr[k+3][l-3] == 2) {
                        status = 2;
                    }
                }
                if(isLegal(k-1,l-1) == 1 && isLegal(k-2,l-2) == 1 && isLegal(k-3,l-3) == 1) {
                    if (arr[k][l] == 2 && arr[k - 1][l - 1] == 2 && arr[k - 2][l - 2] == 2 &&
                            arr[k - 3][l - 3] == 2) {
                        status = 2;
                    }
                }
            }
        }
        return status;
    }

    /**
     *   Oyun Bitis Fonksiyonlari
     *   Capraz tarafi kontrol eder
     * @return Bitmis ise 1,yoksa 0
     **/
    int crossFinishedMavi(){
        int status = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if(isLegal(i+1,j+1) == 1 && isLegal(i+2,j+2) == 1 && isLegal(i+3,j+3) == 1){
                    if(arr[i][j] == 1 && arr[i+1][j+1] == 1 && arr[i+2][j+2] == 1 && arr[i+3][j+3] == 1) {
                        status = 1;
                    }
                }
                if(isLegal(i-1,j+1) == 1 && isLegal(i-2,j+2) == 1 && isLegal(i-3,j+3) == 1){
                    if(arr[i][j] == 1 && arr[i-1][j+1] == 1 && arr[i-2][j+2] == 1 && arr[i-3][j+3] == 1) {
                        status = 1;
                    }
                }
                if(isLegal(i+1,j-1) == 1 && isLegal(i+2,j-2) == 1 && isLegal(i+3,j-3) == 1){
                    if(arr[i][j] == 1 && arr[i+1][j-1] == 1 && arr[i+2][j-2] == 1 && arr[i+3][j-3] == 1) {
                        status = 1;
                    }
                }
                if(isLegal(i-1,j-1) == 1 && isLegal(i-2,j-2) == 1 && isLegal(i-3,j-3) == 1) {
                    if (arr[i][j] == 1 && arr[i - 1][j - 1] == 1 && arr[i - 2][j - 2] == 1 &&
                            arr[i - 3][j - 3] == 1) {
                        status = 1;
                    }
                }
            }
        }


        return status;
    }




    /**
     * Beraberligi kontrol eder
     * @return Bitmis ise 1,yoksa 0
     */
    int isFilled(){
        int status = 1;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if(arr[i][j] == 0)
                    status = 0;
            }
        }
        return status;
    }

    //Yapay Zeka Komutlari
    //Mantik olarak 3 mavi varsa maviyi kapatir,3 sari varsa tamamlar vs vs.

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3Right(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1 && isLegal(i, j+3) == 1) {
                    if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1 && arr[i][j+3] == 0) {
                        if((isLegal(i+1,j+3)) == 0 || arr[i+1][j + 3] != 0) {
                            if(!status) {
                                arr[i][j + 3] = 2;
                                a[i][j+3].setYellow();
                                lastJ = j+3;
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3RightO(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1 && isLegal(i, j+3) == 1) {
                    if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 2 && arr[i][j+3] == 0) {
                        if(isLegal(i+1,j+3) == 0 || arr[i+1][j + 3] != 0) {
                            if(!status) {
                                arr[i][j + 3] = 2;
                                lastJ = j+3;
                                a[i][j+3].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3Left(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1 && isLegal(i, j-3) == 1) {
                    if (arr[i][j] == 1 && arr[i][j - 1] == 1 && arr[i][j - 2] == 1 && arr[i][j-3] == 0) {
                        if(isLegal(i+1,j-3) == 0 || arr[i+1][j - 3] != 0) {
                            if(!status) {
                                arr[i][j - 3] = 2;
                                lastJ = j-3;
                                a[i][j-3].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3LeftO(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1 && isLegal(i, j-3) == 1) {
                    if (arr[i][j] == 2 && arr[i][j - 1] == 2 && arr[i][j - 2] == 2 && arr[i][j-3] == 0) {
                        if(isLegal(i+1,j-3) == 0 || arr[i+1][j - 3] != 0) {
                            if(!status) {
                                arr[i][j - 3] = 2;
                                lastJ = j-3;
                                a[i][j-3].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2Left(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1) {
                    if (arr[i][j] == 1 && arr[i][j - 1] == 1 && arr[i][j - 2] == 0) {
                        if(isLegal(i+1,j-2) == 0 || arr[i+1][j - 2] != 0) {
                            if(!status) {
                                arr[i][j - 2] = 2;
                                lastJ = j-2;
                                a[i][j-2].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2LeftO(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1) {
                    if (arr[i][j] == 2 && arr[i][j - 1] == 2 && arr[i][j - 2] == 0) {
                        if(isLegal(i+1,j-2) == 0 || arr[i+1][j - 2] != 0) {
                            if(!status) {
                                arr[i][j - 2] = 2;
                                lastJ = j-2;
                                a[i][j-2].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2Right(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1) {
                    if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 0) {
                        if(isLegal(i+1,j+2) == 0 || arr[i+1][j + 2] != 0) {
                            if(!status) {
                                arr[i][j + 2] = 2;
                                lastJ = j+2;
                                a[i][j+2].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2RightO(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1) {
                    if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 0) {
                        if(isLegal(i+1,j+2) == 0 || arr[i+1][j + 2] != 0) {
                            if(!status) {
                                arr[i][j + 2] = 2;
                                lastJ = j+2;
                                a[i][j+2].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3Up(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1 && isLegal(i-3, j) == 1) {
                    if (arr[i][j] == 1 && arr[i-1][j] == 1 && arr[i-2][j] == 1 && arr[i-3][j] == 0) {
                        if(arr[i-3][j] == 0) {
                            if(!status) {
                                arr[i - 3][j] = 2;
                                lastJ = j;
                                a[i-3][j].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer3UpO(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1 && isLegal(i-3, j) == 1) {
                    if (arr[i][j] == 2 && arr[i-1][j] == 2 && arr[i-2][j] == 2 && arr[i-3][j] == 0) {
                        if(arr[i-3][j] == 0) {
                            if(!status) {
                                arr[i - 3][j] = 2;
                                lastJ = j;
                                a[i-3][j].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2Up(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1) {
                    if (arr[i][j] == 1 && arr[i-1][j] == 1 &&  arr[i-2][j] == 0) {
                        if(arr[i-2][j] == 0) {
                            if(!status) {
                                arr[i - 2][j] = 2;
                                lastJ = j;
                                a[i-2][j].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computer2UpO(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1) {
                    if (arr[i][j] == 2 && arr[i-1][j] == 2 &&  arr[i-2][j] == 0) {
                        if(arr[i-2][j] == 0) {
                            if(!status) {
                                arr[i - 2][j] = 2;
                                lastJ = j;
                                a[i - 2][j].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerUp(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1) {
                    if (arr[i][j] == 1 &&  arr[i-1][j] == 0) {
                        if(arr[i-1][j] == 0) {
                            if(!status) {
                                arr[i - 1][j] = 2;
                                lastJ = j;
                                a[i - 1][j].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerUpO(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i - 1, j) == 1 && isLegal(i-2 , j) == 1) {
                    if (arr[i][j] == 2 &&  arr[i-1][j] == 0) {
                        if(arr[i-1][j] == 0) {
                            if(!status) {
                                arr[i - 1][j] = 2;
                                lastJ = j;
                                a[i-1][j].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerRight(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1) {
                    if (arr[i][j] == 1 && arr[i][j + 1] == 0) {
                        if(isLegal(i+1,j+1) == 0 || arr[i+1][j + 1] != 0) {
                            if(!status) {
                                arr[i][j + 1] = 2;
                                lastJ = j+1;
                                a[i][j+1].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerRightO(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j+2) == 1) {
                    if (arr[i][j] == 2 && arr[i][j + 1] == 0) {
                        if(isLegal(i+1,j+1) == 0 || arr[i+1][j + 1] != 0) {
                            if(!status) {
                                arr[i][j + 1] = 2;
                                lastJ = j+1;
                                a[i][j+1].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerLeft(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1) {
                    if (arr[i][j] == 1 &&  arr[i][j - 1] == 0) {
                        if(isLegal(i+1,j-1) == 0 || arr[i+1][j - 1] != 0) {
                            if(!status) {
                                arr[i][j - 1] = 2;
                                lastJ = j-1;
                                a[i][j-1].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerLeftO(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j-1) == 1 && isLegal(i , j-2) == 1) {
                    if (arr[i][j] == 2 &&  arr[i][j - 1] == 0) {
                        if(isLegal(i+1,j-1) == 0 || arr[i+1][j - 1] != 0) {
                            if(!status) {
                                arr[i][j - 1] = 2;
                                lastJ = j-1;
                                a[i][j-1].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return Uygun yeri bulduysa true,bulmadiysa false
     */
    private boolean computerMid(imageViews[][] a){
        boolean status = false;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (isLegal(i, j+1) == 1 && isLegal(i , j-1) == 1) {
                    if (arr[i][j-1] == 1  && arr[i][j + 1] == 1 && arr[i][j] == 0) {
                        if(isLegal(i+1,j) == 0 || arr[i+1][j] != 0) {
                            if(!status) {
                                arr[i][j] = 2;
                                lastJ = j;
                                a[i][j].setYellow();
                                status = true;
                            }
                        }
                    }
                }
            }
        }
        return status;
    }

    //Yapay zekanin hangi mantiga göre calisacagini belirler.

    /**
     *
     * @param a GUI ye mavi veya sari set edebilmek icin
     * @return
     */
    int computerAI(imageViews[][] a){
        if(computer3RightO(a)){
            return 0;
        }
        else if(computer3LeftO(a)){
            return 0;
        }
        else if(computer3UpO(a)){
            return 0;
        }
        else if(computer3Up(a)){
            return 0;
        }
        else if(computer3Left(a)){
            return 0;
        }
        else if(computer3Right(a)){
            return 0;
        }
        else if(computerMid(a)){
            return 0;
        }
        else if(computer2RightO(a)){
            return 0;
        }
        else if(computer2UpO(a)){
            return 0;
        }
        else if(computer2LeftO(a)){
            return 0;
        }
        else if(computer2Up(a)){
            return 0;
        }
        else if(computer2Left(a)){
            return 0;
        }
        else if(computer2Right(a)){
            return 0;
        }
        else if(computerUpO(a)){
            return 0;
        }
        else if(computerRightO(a)){
            return 0;
        }
        else if(computerLeftO(a)){
            return 0;
        }
        else if(computerUp(a)){
            return 0;
        }
        else if(computerRight(a)){
            return 0;
        }
        else if(computerLeft(a)){
            return 0;
        }

        return 0;
    }

    public void setBosluk(int j, int i) {
        arr[j][i] = 0;
    }
    public int getLastJ(){
        return lastJ;
    }

    public void randMavi(imageViews[][] a) {
        boolean status = true;
        boolean isDone = false;
        while (!isDone) {
            Random rand = new Random();
            int n = rand.nextInt(size);
            for (int i = size - 1; i >= 0; --i) {
                if(status){
                    if (arr[i][n] == 0) {
                        a[i][n].setBlue();
                        arr[i][n] = 1;
                        lastJ = n;
                        status = false;
                        isDone = true;
                    }
                }
            }
        }
    }

    public void randSari(imageViews[][] a){
        boolean status = true;
        boolean isDone = false;
        while(!isDone){
            Random rand = new Random();
            int n = rand.nextInt(size);
            for (int i = size -1;i >= 0; --i){
                if(status){
                    if (arr[i][n] == 0) {
                        a[i][n].setYellow();
                        arr[i][n] = 2;
                        lastJ = n;
                        status = false;
                        isDone = true;
                    }
                }
            }
        }
    }

}
