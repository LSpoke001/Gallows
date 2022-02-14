package com.lspoke.gallows;

/*
Продумайте алгоритм, по которому в вашей программе создается массив слов, он определен.
Программа при запуске выбирает слово, которое загадает пользователю.
Далее, в цикле, нужно спрашивать у пользователя букву и открывать ее, если она есть.
 */
public class Gallows {
    public static void main(String[] args){
        GallowsGame gallowsGame = new GallowsGame();
        gallowsGame.game();
    }
}
