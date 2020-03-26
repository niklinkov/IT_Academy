package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static int COLUMN_NUMBER = 3;
    static int ROW_NUMBER = 3;
    static int NUMBER_TO_WIN = 3; //число одинаковых символов для победы
    static int DIFFICUTNESS = 0; //сложность игры


    static char[][] GAME_FIELD = new char[ROW_NUMBER][COLUMN_NUMBER];

    static char PLAYER = 'X';
    static char PK = 'O';
    static char EMPTY = '*';

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void initGameField() {
        for (int i = 0; i < ROW_NUMBER; i++) {
            for (int j = 0; j < COLUMN_NUMBER; j++) {
                GAME_FIELD[i][j] = EMPTY;
            }
        }
    }

    public static void printGameField() {
        System.out.println("-------");
        for (int i = 0; i < ROW_NUMBER; i++) {
            System.out.print("|");
            for (int j = 0; j < COLUMN_NUMBER; j++) {
                System.out.print(GAME_FIELD[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    public static void playerStep() {
        int x,y;
        do {
            System.out.println("Введите кординаты:");
            x = checkLine(sc.nextLine()) - 1;
            y = checkLine(sc.nextLine()) - 1;
        } while ( x < 0 || y < 0 || x > ROW_NUMBER - 1 || y > COLUMN_NUMBER - 1 || GAME_FIELD[y][x] != EMPTY);
        GAME_FIELD[y][x] = PLAYER;
    }

    public static void pkStep(int mode) {
        int x=0,y=0;
        NextPosition nextPos=new NextPosition();
        switch (mode) {
            case 0:
                getRandomPos(nextPos);
                System.out.println("random pos counter=" + nextPos.couter + " xPOs=" + (nextPos.posInRow + 1) + " yPOs=" + (nextPos.posInColumn + 1));
                break;

            case 1:
                findNextStepAgainstPlayer(nextPos);
                if (nextPos.couter<NUMBER_TO_WIN-1) {
                    getRandomPos(nextPos);
                }
                System.out.println("counter=" + nextPos.couter + " xPOs=" + (nextPos.posInRow + 1) + " yPOs=" + (nextPos.posInColumn + 1));
                break;

            case 2:
                findNextStepAgainstPlayer(nextPos);
                if (nextPos.couter<NUMBER_TO_WIN-2) {
                    getRandomPos(nextPos);
                }
                System.out.println("counter=" + nextPos.couter + " xPOs=" + (nextPos.posInRow + 1) + " yPOs=" + (nextPos.posInColumn + 1));
                break;

            case 3:
                NextPosition posToWin = new NextPosition();
                findNextStepForWin(posToWin,PK,PLAYER);
                findNextStepForWin(nextPos,PLAYER,PK);
     //           findNextStepAgainstPlayer(nextPos);
                if (posToWin.couter>=NUMBER_TO_WIN-1) {
                    nextPos=posToWin;
                }
                System.out.println("counter=" + nextPos.couter + " xPOs=" + (nextPos.posInRow + 1) + " yPOs=" + (nextPos.posInColumn + 1));
                System.out.println("counter=" + posToWin.couter + " xPOs=" + (posToWin.posInRow + 1) + " yPOs=" + (posToWin.posInColumn + 1));
                break;


        }
        GAME_FIELD[nextPos.posInColumn][nextPos.posInRow] = PK;

    }

    public static boolean checkWinnable(char symb) {
        int counter;
//        int posInColumn=0;
        for (int posInColumn = 0; posInColumn < ROW_NUMBER; posInColumn++) {
            for (int posInRow = 0; posInRow < COLUMN_NUMBER; posInRow++) {
                //System.out.println("xPOS="+posInRow);
                //System.out.println("yPOS="+posInColumn);
                if (GAME_FIELD[posInRow][posInColumn]==symb) {
//                    System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                    //если в ячеке есть искомый символ, проверить встречаются ли выигрышные для этой позиции
                    //вариант 1. Диагональ вверх-вправо
                    //System.out.println("xPOS="+posInRow+"yPOS="+posInColumn);
                    if ((posInRow+(NUMBER_TO_WIN-1))<COLUMN_NUMBER && (posInColumn-(NUMBER_TO_WIN-1))>=0) {

                        if (GAME_FIELD[posInRow+(NUMBER_TO_WIN-1)][posInColumn-(NUMBER_TO_WIN-1)]==symb) {
//                            System.out.println("xPOs="+(posInRow+(NUMBER_TO_WIN-1))+"yPOS="+(posInColumn-(NUMBER_TO_WIN-1)));
                            counter=0;
                            for (int i = posInColumn, j=posInRow; j <= posInRow+NUMBER_TO_WIN-1; i--, j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                               if (GAME_FIELD[j][i]==symb) {counter+=1;
//                               System.out.println("["+posInRow+","+posInColumn+"]="+symb);
//                               System.out.println("diagon counter="+counter);
                                }
                                  // else break;
                            }
                            //если счетчик равен кол-ву необходимых для побед очков - признак выигрыша
                            if (counter>=NUMBER_TO_WIN) {
                                return true;
                            }
//                            System.out.println("Кто-то выиграл");
                        }
                    }
                    //вариант 2. По вертикали
                    if ((posInRow+(NUMBER_TO_WIN-1))<COLUMN_NUMBER) { // && GAME_FIELD[posInRow+(NUMBER_TO_WIN-1)][posInColumn]==symb) {
                        if (GAME_FIELD[posInRow+(NUMBER_TO_WIN-1)][posInColumn]==symb) {
                            //System.out.println("xPOs="+(posInRow+(NUMBER_TO_WIN-1))+"yPOS="+posInColumn);
//                            System.out.println("Кто-то выиграл");
                            counter=0;
                            for (int j = posInRow; j <= posInRow+NUMBER_TO_WIN-1; j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                                    if (GAME_FIELD[j][posInColumn]==symb) {counter+=1;
//                                        System.out.println("["+posInRow+","+posInColumn+"]="+symb);
//                                System.out.println("vert counter="+counter);
                                    }
                                  //  else break;
                                }
                        //System.out.println("vert counter="+counter);
                            //если счетчик равен кол-ву необходимых для побед очков - признак выигрыша
                            if (counter>=NUMBER_TO_WIN) {
                                return true;
                            }
                        }
                    }
                    //вариант 3. Диагональ вниз-вправо
                    if ((posInColumn+(NUMBER_TO_WIN-1))<ROW_NUMBER && (posInRow+(NUMBER_TO_WIN-1))<COLUMN_NUMBER) {
                        if (GAME_FIELD[posInRow+(NUMBER_TO_WIN-1)][posInColumn+(NUMBER_TO_WIN-1)]==symb) {
//                            System.out.println("xPOs="+(posInRow+(NUMBER_TO_WIN-1))+"yPOS="+(posInColumn+(NUMBER_TO_WIN-1)));
//                            System.out.println("Кто-то выиграл");
                            counter=0;
                            for (int i = posInColumn, j=posInRow; j <= posInRow+NUMBER_TO_WIN-1; i++, j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                                if (GAME_FIELD[j][i]==symb) {counter+=1;
//                                    System.out.println("["+posInRow+","+posInColumn+"]="+symb);
//                                    System.out.println("diagon 2 counter="+counter);
                                    }
                               // else break;
                            }
                            //если счетчик равен кол-ву необходимых для побед очков - признак выигрыша
                            if (counter>=NUMBER_TO_WIN) {
                                return true;
                            }
                        }
                    }
                    //вариант 4. По горизонтали
                    if ((posInColumn+(NUMBER_TO_WIN-1))<ROW_NUMBER) {
                        if (GAME_FIELD[posInRow][posInColumn+(NUMBER_TO_WIN-1)]==symb) {
//                            System.out.println("Вариант 4. Горизонталь"); //   ("xPOs="+posInRow+"yPOS="+(posInColumn+(NUMBER_TO_WIN-1)));
//                            System.out.println("Кто-то выиграл");
                            counter=0;
                            for (int j = posInColumn; j <= posInColumn+NUMBER_TO_WIN-1; j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                                if (GAME_FIELD[posInRow][j]==symb) { counter+=1;
//                                System.out.println("hor counter="+counter);
                                }
                              //  else break;
                            }
                            if (counter>=NUMBER_TO_WIN) {
                                return true;}
                        }
                    }
                }
                //если ячейка не содержит искомого значения переместится в следующую
                //System.out.println("yPOS="+posInColumn+"xPOS="+posInRow);
            }

        }

        return false;
    }

    //ИИ для хода ПК.
    //метод возвращающий координаты, чтобы остановить игрока
    public static void findNextStepAgainstPlayer(NextPosition nextPos) {  //параметр mode задает сложность игры, на будущее: 0 - ИИ отключен, 1 - проверяет на -1 фишку игрока до победы, 2 - проверяет на -2 фишки игрока на победу, 3 - разрывает игрока в клочья :))
        int maxSymolsInSequence=0;
        int tmpPosInRow=0;
        int tmpPosInColumn=0;
//        NextPosition nextPos = new NextPosition(); //класс передающий информацию о следующем ходе
        int counter;
        char symb = PLAYER;
//      цикл для проверки всего поля
//        System.out.println("Старт цикла");
        nextPos.couter=0;
        for (int posInColumn = 0; posInColumn < ROW_NUMBER; posInColumn++) {
            for (int posInRow = 0; posInRow < COLUMN_NUMBER; posInRow++) {
               // if (GAME_FIELD[posInColumn][posInRow] == symb) { //если в ячейке стоит символ игрока
                  //если в ячеке есть искомый символ, проверить комбинации на наличие дополнительных символов
//
                    //вариант 2. По горизонтали  вперед
                    if ((posInRow + (NUMBER_TO_WIN - 1)) < COLUMN_NUMBER) { // && GAME_FIELD[posInRow+(NUMBER_TO_WIN-1)][posInColumn]==symb) {
//                        if (GAME_FIELD[posInRow + (NUMBER_TO_WIN - 1)][posInColumn] == symb) {
                            //System.out.println("xPOs="+(posInRow+(NUMBER_TO_WIN-1))+"yPOS="+posInColumn);
//                            System.out.println("Кто-то выиграл");
                            counter = 0;
                            for (int j = posInRow; j <= posInRow + NUMBER_TO_WIN - 1; j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                                if (GAME_FIELD[posInColumn][j] == symb) {
                                    counter += 1;
//                                        System.out.println("["+posInRow+","+posInColumn+"]="+symb);
//                                System.out.println("vert counter="+counter);
                                }
                                 else if ((GAME_FIELD[posInColumn][j] == PK)) {
                            counter=0;
                            break;
                        }
                        else {
                            tmpPosInRow=j;
                            tmpPosInColumn=posInColumn;
                            //break;
                        }
                        // else break;
//                                System.out.println("empty vert xPOs="+tmpPosInRow+" yPOs="+tmpPosInColumn);
                    }
                    //проверка является ли текущая последовательность максимальной
                    //метод сравнивающий текущую последовательность с максимальной
                    if (counter >= maxSymolsInSequence) {
                        maxSymolsInSequence=counter;
                        nextPos.couter=counter;
                        nextPos.posInRow=tmpPosInRow;
                        nextPos.posInColumn=tmpPosInColumn;
                    }
                                //  else break;
                    }

                    //вариант 4. По вертикали
                    if ((posInColumn + (NUMBER_TO_WIN - 1)) < ROW_NUMBER) {
//                        if (GAME_FIELD[posInRow][posInColumn + (NUMBER_TO_WIN - 1)] == symb) {
//                            System.out.println("Вариант 4. Горизонталь"); //   ("xPOs="+posInRow+"yPOS="+(posInColumn+(NUMBER_TO_WIN-1)));
//                            System.out.println("Кто-то выиграл");
                            counter = 0;
                            for (int j = posInColumn; j <= posInColumn + NUMBER_TO_WIN - 1; j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                                if (GAME_FIELD[j][posInRow] == symb) {
                                    counter += 1;
//                                System.out.println("hor counter="+counter);
                                }
                                else if ((GAME_FIELD[j][posInRow] == PK)) {
                                    counter=0;
                                    break;
                                }
                                else {
                                    tmpPosInRow=posInRow;
                                    tmpPosInColumn=j;
//                                    break;
                                }
                                // else break;
//                                System.out.println("empty hor xPOs="+tmpPosInRow+" yPOs="+tmpPosInColumn);
                            }
                            //проверка является ли текущая последовательность максимальной
                            //метод сравнивающий текущую последовательность с максимальной

                            if (counter >= maxSymolsInSequence) {
                                maxSymolsInSequence=counter;
                                nextPos.couter=counter;
                                nextPos.posInRow=tmpPosInRow;
                                nextPos.posInColumn=tmpPosInColumn;
                            }
                            //  else break;
                        }

                    //вариант 1. Диагональ вверх-вправо
                    if ((posInRow + (NUMBER_TO_WIN-1)) < COLUMN_NUMBER && (posInColumn - (NUMBER_TO_WIN-1)) >= 0) { //проверка что конец выигрышной серии лежит на игровом поле

//                        if (GAME_FIELD[posInRow + (NUMBER_TO_WIN - 1)][posInColumn - (NUMBER_TO_WIN - 1)] == symb) {
//                            System.out.println("Координаты конца последовательности xPOs="+(posInRow+(NUMBER_TO_WIN-1))+" yPOS="+(posInColumn-(NUMBER_TO_WIN-1)));
                        counter = 0;
                        for (int j = posInColumn, i = posInRow; i <= posInRow + NUMBER_TO_WIN-1; i++, j--) { //проверить наличие других символов в этом нарпавлении
                            if (GAME_FIELD[j][i] == symb) {
                                counter += 1;
//                                    System.out.println("Значение в ячейке ["+i+","+j+"]="+GAME_FIELD[j][i]);
//                                System.out.println("diagon counter="+counter);
                            }
                            else if ((GAME_FIELD[j][i] == PK)) {
                                counter=0;
//                                    System.out.println("Значение в ячейке ["+i+","+j+"]="+GAME_FIELD[j][i]);
//                                    System.out.println("Нет смысла проверять дальше");
                                break;
                            }
                            else  {
//                                    System.out.println("Значение в ячейке ["+i+","+j+"]="+GAME_FIELD[j][i]);
                                tmpPosInRow=i;
                                tmpPosInColumn=j;
//                                    System.out.println("in cycle xPOs="+(tmpPosInRow+1)+" yPOs="+(tmpPosInColumn+1));
//                                break;
                            }
                            // else break;

                        }
                        //проверка является ли текущая последовательность максимальной
                        //метод сравнивающий текущую последовательность с максимальной
//                        System.out.println("out cycle xPOs="+(tmpPosInRow+1)+" yPOs="+(tmpPosInColumn+1));
                        if (counter >= maxSymolsInSequence) {
                            maxSymolsInSequence=counter;
                            nextPos.couter=counter;
                            nextPos.posInRow=tmpPosInRow;
                            nextPos.posInColumn=tmpPosInColumn;
                        }
//                        }
                    }

                    //вариант 3. Диагональ вниз-вправо
                    if ((posInColumn + (NUMBER_TO_WIN - 1)) < ROW_NUMBER && (posInRow + (NUMBER_TO_WIN - 1)) < COLUMN_NUMBER) {
//                        if (GAME_FIELD[posInRow + (NUMBER_TO_WIN - 1)][posInColumn + (NUMBER_TO_WIN - 1)] == symb) {
//                            System.out.println("xPOs="+(posInRow+(NUMBER_TO_WIN-1))+"yPOS="+(posInColumn+(NUMBER_TO_WIN-1)));
//                            System.out.println("Кто-то выиграл");
                        counter = 0;
                        for (int i = posInColumn, j = posInRow; j <= posInRow + NUMBER_TO_WIN - 1; i++, j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                            if (GAME_FIELD[i][j] == symb) {
                                counter += 1;
//                                    System.out.println("["+posInRow+","+posInColumn+"]="+symb);
//                                    System.out.println("diagon 2 counter="+counter);
                            }
                            else if ((GAME_FIELD[i][j] == PK)) {
                                counter=0;
                                break;
                            }
                            else {
                                tmpPosInRow=j;
                                tmpPosInColumn=i;
//                                break;
                            }
                            // else break;
//                                System.out.println("empty diag down xPOs="+tmpPosInRow+" yPOs="+tmpPosInColumn);
                        }
                        //проверка является ли текущая последовательность максимальной
//                            //метод сравнивающий текущую последовательность с максимальной
                        if (counter >= maxSymolsInSequence) {
                            maxSymolsInSequence=counter;
                            nextPos.couter=counter;
                            nextPos.posInRow=tmpPosInRow;
                            nextPos.posInColumn=tmpPosInColumn;
                        }
                        //  else break;
                    }

//                }

            }

        }
        //System.out.println("counter="+nextPos.couter+" xPOs="+(nextPos.posInRow+1)+" yPOs="+(nextPos.posInColumn+1));
        //return nextPos;
        if (GAME_FIELD[nextPos.posInColumn][nextPos.posInRow] != EMPTY) {
            getRandomPos(nextPos);
        }
    }
    //метод возвращающий координаты для победы ПК
    public static void findNextStepForWin(NextPosition nextPos, int own, int enemy) {  //параметр mode задает сложность игры, на будущее: 0 - ИИ отключен, 1 - проверяет на -1 фишку игрока до победы, 2 - проверяет на -2 фишки игрока на победу, 3 - разрывает игрока в клочья :))
        int maxSymolsInSequence=0;  //счетчик глобальный
        int tmpPosInRow=0;  //позиця по Х для следующего хода
        int tmpPosInColumn=0; //позиця по Y для следующего хода
 //        NextPosition nextPos = new NextPosition(); //класс передающий информацию о следующем ходе
        int counter; //счетчик локальный
//        char symb = PK;
//        char enemy = PLAYER;
//      цикл для проверки всего поля
//       System.out.println("Старт цикла");
        nextPos.couter=0;
        for (int posInColumn = 0; posInColumn < ROW_NUMBER; posInColumn++) {
            for (int posInRow = 0; posInRow < COLUMN_NUMBER; posInRow++) {
//                if (GAME_FIELD[posInColumn][posInRow] == symb) { //если в ячейке стоит символ игрока
//                  //если в ячеке есть искомый символ, проверить комбинации на наличие дополнительных символов

                    //вариант 2. По горизонтали
                    if ((posInRow + (NUMBER_TO_WIN - 1)) < COLUMN_NUMBER) { // && GAME_FIELD[posInRow+(NUMBER_TO_WIN-1)][posInColumn]==symb) {
//                        if (GAME_FIELD[posInRow + (NUMBER_TO_WIN - 1)][posInColumn] == symb) {
//                        System.out.println("xPOs="+(posInRow+(NUMBER_TO_WIN-1))+"yPOS="+posInColumn);
//                            System.out.println("Кто-то выиграл");
                        counter = 0;
                        for (int j = posInRow; j <= posInRow + NUMBER_TO_WIN - 1; j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                            if (GAME_FIELD[posInColumn][j] == own) {
                                counter += 1;
//                                        System.out.println("["+posInRow+","+posInColumn+"]="+symb);
//                                System.out.println("vert counter="+counter);

                            }
                            else if ((GAME_FIELD[posInColumn][j] == enemy)) {
                                counter=0;
                                break;
                            }
                            else {
                                tmpPosInRow=j;
                                tmpPosInColumn=posInColumn;
//                                break;
                            }
                            // else break;
//                                System.out.println("empty vert xPOs="+tmpPosInRow+" yPOs="+tmpPosInColumn);
                        }
                        //проверка является ли текущая последовательность максимальной
                        //метод сравнивающий текущую последовательность с максимальной
                        if (counter >= maxSymolsInSequence) {
                            maxSymolsInSequence=counter;
                            nextPos.couter=counter;
                            nextPos.posInRow=tmpPosInRow;
                            nextPos.posInColumn=tmpPosInColumn;
                        }
                        //  else break;
                    }

                    //вариант 4. По вертикали
                    if ((posInColumn + (NUMBER_TO_WIN - 1)) < ROW_NUMBER) {
//                        if (GAME_FIELD[posInRow][posInColumn + (NUMBER_TO_WIN - 1)] == symb) {
//                            System.out.println("Вариант 4. Горизонталь"); //   ("xPOs="+posInRow+"yPOS="+(posInColumn+(NUMBER_TO_WIN-1)));
//                            System.out.println("Кто-то выиграл");
                        counter = 0;
                        for (int j = posInColumn; j <= posInColumn + NUMBER_TO_WIN - 1; j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                            if (GAME_FIELD[j][posInRow] == own) {
                                counter += 1;
//                                System.out.println("hor counter="+counter);
                            }
                            else if ((GAME_FIELD[j][posInRow] == enemy)) {
                                counter=0;
                                break;
                            }
                            else {
                                tmpPosInRow=posInRow;
                                tmpPosInColumn=j;
                            }
                            // else break;
//                                System.out.println("empty hor xPOs="+tmpPosInRow+" yPOs="+tmpPosInColumn);
                        }
                        //проверка является ли текущая последовательность максимальной
                        //метод сравнивающий текущую последовательность с максимальной

                        if (counter >= maxSymolsInSequence) {
                            maxSymolsInSequence=counter;
                            nextPos.couter=counter;
                            nextPos.posInRow=tmpPosInRow;
                            nextPos.posInColumn=tmpPosInColumn;
                        }
                        //  else break;
                    }

                    //вариант 1. Диагональ вверх-вправо
                    if ((posInRow + (NUMBER_TO_WIN-1)) < COLUMN_NUMBER && (posInColumn - (NUMBER_TO_WIN-1)) >= 0) { //проверка что конец выигрышной серии лежит на игровом поле

//                        if (GAME_FIELD[posInRow + (NUMBER_TO_WIN - 1)][posInColumn - (NUMBER_TO_WIN - 1)] == symb) {
//                            System.out.println("Координаты конца последовательности xPOs="+(posInRow+(NUMBER_TO_WIN-1))+" yPOS="+(posInColumn-(NUMBER_TO_WIN-1)));
                        counter = 0;
                        for (int j = posInColumn, i = posInRow; i <= posInRow + NUMBER_TO_WIN-1; i++, j--) { //проверить наличие других символов в этом нарпавлении
                            if (GAME_FIELD[j][i] == own) {
                                counter += 1;
//                                    System.out.println("Значение в ячейке ["+i+","+j+"]="+GAME_FIELD[j][i]);
//                                System.out.println("diagon counter="+counter);
                            }
                            else if ((GAME_FIELD[j][i] == enemy)) {
                                counter=0;
//                                    System.out.println("Значение в ячейке ["+i+","+j+"]="+GAME_FIELD[j][i]);
//                                    System.out.println("Нет смысла проверять дальше");
                                break;
                            }
                            else  {
//                                    System.out.println("Значение в ячейке ["+i+","+j+"]="+GAME_FIELD[j][i]);
                                tmpPosInRow=i;
                                tmpPosInColumn=j;
//                                    System.out.println("in cycle xPOs="+(tmpPosInRow+1)+" yPOs="+(tmpPosInColumn+1));
//                                break;
                            }
                            // else break;

                        }
                        //проверка является ли текущая последовательность максимальной
                        //метод сравнивающий текущую последовательность с максимальной
//                        System.out.println("out cycle xPOs="+(tmpPosInRow+1)+" yPOs="+(tmpPosInColumn+1));
                        if (counter >= maxSymolsInSequence) {
                            maxSymolsInSequence=counter;
                            nextPos.couter=counter;
                            nextPos.posInRow=tmpPosInRow;
                            nextPos.posInColumn=tmpPosInColumn;
                        }
//                        }
                    }

                    //вариант 3. Диагональ вниз-вправо
                    if ((posInColumn + (NUMBER_TO_WIN - 1)) < ROW_NUMBER && (posInRow + (NUMBER_TO_WIN - 1)) < COLUMN_NUMBER) {
//                        if (GAME_FIELD[posInRow + (NUMBER_TO_WIN - 1)][posInColumn + (NUMBER_TO_WIN - 1)] == symb) {
//                            System.out.println("xPOs="+(posInRow+(NUMBER_TO_WIN-1))+"yPOS="+(posInColumn+(NUMBER_TO_WIN-1)));
//                            System.out.println("Кто-то выиграл");
                        counter = 0;
                        for (int i = posInColumn, j = posInRow; j <= posInRow + NUMBER_TO_WIN - 1; i++, j++) {
//                                System.out.println("["+posInRow+","+posInColumn+"]="+symb);
                            if (GAME_FIELD[i][j] == own) {
                                counter += 1;
//                                    System.out.println("["+posInRow+","+posInColumn+"]="+symb);
//                                    System.out.println("diagon 2 counter="+counter);
                            }
                            else if ((GAME_FIELD[i][j] == enemy )) {
                                counter=0;
                                break;
                            }
                            else {
                                tmpPosInRow=j;
                                tmpPosInColumn=i;
//                                break;
                            }
                            // else break;
//                                System.out.println("empty diag down xPOs="+tmpPosInRow+" yPOs="+tmpPosInColumn);
                        }
                        //проверка является ли текущая последовательность максимальной
//                            //метод сравнивающий текущую последовательность с максимальной
                        if (counter >= maxSymolsInSequence) {
                            maxSymolsInSequence=counter;
                            nextPos.couter=counter;
                            nextPos.posInRow=tmpPosInRow;
                            nextPos.posInColumn=tmpPosInColumn;
                        }
                        //  else break;
                    }

                }

//            }

        }
        //System.out.println("counter="+nextPos.couter+" xPOs="+(nextPos.posInRow+1)+" yPOs="+(nextPos.posInColumn+1));
//        return nextPos;
        if (GAME_FIELD[nextPos.posInColumn][nextPos.posInRow] != EMPTY) {
            getRandomPos(nextPos);
        }
    }

    public static boolean checkGameFieldFull() {
        for (int i = 0; i < ROW_NUMBER; i++) {
            for (int j = 0; j < COLUMN_NUMBER; j++) {
                if (GAME_FIELD[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int checkLine(String line) {
        try {
            return Integer.parseInt(line);
        } catch (Exception e) {
            throw new RuntimeException("нужно вводить число!");
        }
    }

    public static void getRandomPos(NextPosition pos) {
//        NextPosition rPos = new NextPosition();
        int x;
        int y;
        do {
            x = random.nextInt(ROW_NUMBER);
            y = random.nextInt(COLUMN_NUMBER);
        } while (x < 0 || y < 0 || x > ROW_NUMBER - 1 || y > COLUMN_NUMBER - 1 || GAME_FIELD[y][x] != EMPTY);
        pos.posInRow=x;
        pos.posInColumn=y;
    //return rPos;
    }

    public static int getDificultness () {
        int d;
        Scanner sc=new Scanner(System.in);
        do {
        System.out.println("Выберите сложность игры. Введите число от 0 до 3");
        if (sc.hasNextInt()){
        d = Integer.parseInt(sc.nextLine());}
        else d=-1;
        }
            while (d<0 || d>3);
        System.out.println("Уровень сложности:"+d);


        return d;
    }

    public static void main(String[] args) {

        int dif = getDificultness();
        initGameField();
        printGameField();

        while (!checkGameFieldFull()) {
            playerStep();
            printGameField();

            if (checkWinnable(PLAYER)) {
                System.out.println("Победил игрок!");
                break;
            }

            if (checkGameFieldFull()) {
                System.out.println("Ничья!");
                break;
            }

            pkStep(dif);
            printGameField();

            if (checkWinnable(PK)) {
                System.out.println("Победил pk");
                break;
            }

            if (checkGameFieldFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }


    static class NextPosition {
        int posInRow;
        int posInColumn;
        int couter;
    }
}
