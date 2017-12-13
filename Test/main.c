/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Nicolle
 *
 * Created on September 16, 2016, 10:27 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int addDigits(int input);

int main(int argc, char** argv) {
    int opt;
    printf("%d\n", (823%100)/10);
    printf("Enter a number:");
    scanf("%d", &opt);
    
    int total = addDigits(opt);
    
    printf("The total of all digits is %d.", total);
    
    return (EXIT_SUCCESS);
}

int addDigits(int input) {
    int input1 =0;
    if (input < 10) {
        return input;
    } 
    else {
        return (input%10+addDigits(input/10));
    }
}