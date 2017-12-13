//Michael Rubenstein
//mgr6fb
//homework2
//october 10, 2016

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define ROW 6
#define COL 4
#define MAX 20

int costMatrix[ROW][COL]={{500,200,200,500},
			  {500,200,200,500},
			  {500,200,200,500},
			  {500,200,200,500},
			  {500,200,200,500},
			  {500,200,200,500}};
void initialSeats(char flight[][COL],int count);'
int displayMenu(int);
void printFlightMap(char flight[][COL]);
int loginMatch(int passcode, int adminPasscode);
int getTotalRevenue(char f1[][COL], char f2[][COL], char f3[][COL]);
void flightMenu();
void seatReservation(char flight[][COL]);

int main(void) {
srand(time(NULL));
initializeSeats(char flight[][COL]);

switch (displayMenu){
case 1:
	int passcode;
	int adminPasscode;
	loginMatch(int passcode,int adminPasscode);
	printFlightMap(char flight[][COL]);
	getTotalRevenue(char f1[][COL], char f2[][COL], char f3[][COL]);
	printf("\nYou are logged out now!");
	break;
case 2:
	flightMenu();
	printFlightMap(char flight[][COL]);
	seatReservation(char flight[][COL]);
	break;
case 3:
	printf("Terminating the Program\n\nThank you for using Joe's Airline Booking system");
	break;
default:
	printf("\nWrong option! Choose a right option again\n");
	goto initializeSeats(char flight[][COL]);
}
return 0;
}

void initializeSeats(char flight[][COL]){
int i;
int j;
	for (i=0; i<=1; i++){
		flight[i]=rand()%2;
		for (j=0; j<=4; j++){
			COL[j]=rand()%2;}
}				
}

int displayMenu(){
int choice;
printf("******WELCOME TO JOE'S AIRLINE BOOKING SYSTEM******\n\n");
printf("1.)Admin Log-in\n2.)Reserve a seat\n3.)Exit\nchoose an option:");
scanf("%d", &choice);
if (choice>=1&&choice<=3){
return choice;
else return 0;
}

void printFlightMap(char flight[][COL]){
int i;
int j;
for (i=0; i<=6; i++){
	for (j=0; j<=4; j++){
if (flight[][COL]=0){
	printf('O');
else {printf ('X'};
}}
printf("\n");}
}

int loginMatch(int passcode, int adminPasscode){
int num;
int pass;
printf("\nenter the login passcode to login as admin");
scanf("%d",&pass);
while (pass<105016||pass>105016)
{printf("\ninvalid Passcode combination\nenter a passcode to login as admin");
scanf("%d",&pass);
}
return 1;
}

