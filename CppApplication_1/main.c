//Evonne Weeden
//HW 2

#include<stdio.h>
#include <stdlib.h>
#include <time.h>
#include<string.h>
#define ROW 6
#define COL 4
#define MAX 25

int costMatrix[ROW][COL]={{300,200,200,300},
                            {300,200,200,300},
                            {300,200,200,300},
                            {300,200,200,300},
                            {300,200,200,300},
                            {300,200,200,300}};

void initialSeats(char flight[][COL],int count);
void displayMenu();
void printFlightMap(char flight[][COL]);
int loginMatch(char string1[],char string2[]);
int getTotalRevenue(char flight1[][COL],char flight2[][COL],char flight3[][COL]);
void flightMenu();
void seatReservation(char flight[][COL]);
void printMessage(char name[],char num[]);

int main (void){

    srand(time(NULL));
    
    char input_password[MAX],input_pawprint[MAX],name[MAX];
    char flight_number[]="MIA1050";
    char flight_number2[]="BA1050";
    char flight_number3[]="LAS1050";
    char adminPawprint[]="nalyv2";
    char adminPassword[]="cmp_sc1050";
    char flight_1[ROW][COL];
    char flight_2[ROW][COL];
    char flight_3[ROW][COL];
    int choice=0;
    int Pawp=0;
    int pass=0;
    int seats=rand()%5+1; 
    int flightoption=0;
    
    initialSeats(flight_1, seats);
    initialSeats(flight_2, seats);
    initialSeats(flight_3, seats);

    displayMenu();
    scanf("%d",&choice);
    
    while(choice<1 || choice>3)
     {
        printf("Invalid option, choose again\n");
	displayMenu();      
 	 scanf("%d", &choice);
    }
    switch(choice){
        case 1:
            
	    printf("Enter Admin Pawprint\n");
            scanf("%s",input_pawprint);
            Pawp=(loginMatch(adminPawprint,input_pawprint));

            printf("Enter Admin password\n");
            scanf("%s",input_password);
	    pass=(loginMatch(adminPassword,input_password));    
            
            while(Pawp==0 ||pass==0){
                printf("Invalid Pawprint and Password combination\n");
                printf("Enter Admin Pawprint\n");
                scanf("%s",input_pawprint);
		Pawp=(loginMatch(adminPawprint,input_pawprint));
                
                printf("Enter Admin password\n");
                scanf("%s", input_password);
		pass=(loginMatch(adminPassword,input_password));
            }
	int total=0;
                printf("\n\n Printing the Flight Map of the flight: Columbia to Miami...\n");
                printFlightMap(flight_1);

                printf("\n\n Printing the Flight Map of the flight: Columbia to Nashville...\n");
                printFlightMap(flight_2);

                printf("\n\n Printing the Flight Map of the flight: Columbia to Las Vegas...\n");
                printFlightMap(flight_3);

                total=getTotalRevenue(flight_1,flight_2,flight_3);
                printf("The total earning from all the flights is %d\n You are logged out now!\n",total);

		printf("You are now logged out\n");

	
	break;

        case 2:
		
		flightMenu();
		scanf("%d",&flightoption);

		while(flightoption<1 || flightoption>3)
		{
			flightMenu();
		}

		printf("Enter your first name\n");
		scanf("%s",name);


		while(flightoption==1)
		{

			seatReservation(flight_1);
			
			printMessage(flight_number,name);

		
  		}
		while(flightoption==2)
		{
			
                        printMessage(flight_number2,name);

			seatReservation(flight_2);
		
		}
		while(flightoption==3)
		{
                        printMessage(flight_number3,name);

			seatReservation(flight_3);
				
		}
		
		
		               
        case 3:
            printf("Terminating the program\n");
	    printf(" Thank you for using Joe's Airline Booking System. \n");
       
	    break;
	} 

	return 0;
    }
    
    
    
    void initialSeats(char flight[][COL],int count){
        int x=0,y=0;
        
        for(x=0;x<ROW;x++){
            for(y=0;y<COL;y++){
        
                flight[x][y]='O';
            }
    }
        
        for(x=0;x<count;x++){
            x=rand()%ROW;
            y=rand()%COL;
            
                flight[x][y]='X';
        }
}
    void displayMenu(){
        printf("1.) Admin Log-in\n 2.)Reserve a seat\n 3.)Exit\n");
    }
    
    void printFlightMap(char flight[][COL]){
        int x;
        int y;
        for (x=0;x<ROW;x++)
            for (y=0;y<COL;y++)
        {
            printf("%c",flight[x][y]);
        }
        }
    int loginMatch(char string1[],char string2[]){
        if(strcmp(string1,string2)==0)
            return 1;
        else
            return 0;
    }
    int getTotalRevenue(char flight1[][COL],char flight2[][COL],char flight3[][COL]){
        int x,y;
        int total=0;
        
        for(x=0;x<ROW;x++)
        {
            for(y=0;y<COL;y++)
            {
                if(flight1[x][y]=='x')
                {
                    total+=costMatrix[x][y];
                }
                if(flight2[x][y]=='x')
                {
                    total+=costMatrix[x][y];
                }
                if(flight3[x][y]=='x')
                {
                    total+=costMatrix[x][y];
                }
            }
        }
        return total;
}

    void flightMenu(){
        printf("Choose a flight\n 1.)CoMo--> Miami\n 2.)CoMo--> Nashville\n 3.)CoMo--> Las Vegas\n");
    }
    void seatReservation(char flight[][COL]){
        printFlightMap(flight);
        int row=0;
        int col=0;
        
        printf("Which seat row do you want?\n");
        scanf("%d",&row);
        
        printf("Which seat column do you want? \n");
        scanf("%d",&col);
        
        while(row<0 || row>5){
            printf("Invalid choice \n ");
            scanf("%d",&row);
            
        }
        while(col<0 || col>3){
            printf("Invalid choice \n");
            scanf("%d",&col);
        }
        while(flight[row][col]=='x'){
            printf("Sorry this seat is occupied \n");
            printf("Which new seat row do you prefer?");
            scanf("%d",&row);
            
            printf("Which new seat column do you want? \n");
            scanf("%d",&col);
            
            while(row<0 || row>5){
                printf("Invalid choice \n ");
                scanf("%d",&row);
                
            }
            while(col<0 || col>3){
                printf("Invalid choice \n");
                scanf("%d",&col);
            
        }
            flight[row][col]='x';
            printf("Your seat has been reserved\n");
            printFlightMap(flight);
	}    
}
    void printMessage(char name[],char num[]){
        char x[MAX];
        int i=0;
        int j=0;
        int s=0;
        int t=0;
        
        while(name[i] != '\0'){
            i++;
        }
        while(num[j] != '\0'){
            j++;
        }
        if(i>j)
        {
             while(s<= i+j){
                if (t<j){
                    x[s]=name[t];
                    s++;
             
                    x[s]=num[t];
                    t++;
                    s++;
             }
                    else
                        x[s]=name[t];
                 t++;
                 s++;
                 
                        }
        }

        else if(j>=i)
        {
            while(s<= i+j){
                if (t<j){
                    x[s]=name[t];
                    s++;
                    
                    x[s]=num[t];
                    t++;
                    s++;
                }
                else
                    x[s]=num[t];
                t++;
                s++;
                
            }
        }
        
        printf("\n Congrats %s, your flight %s is booked. Your eticket number is: %s \n Enjoy Speing Break!",name,num,x);
	}        
