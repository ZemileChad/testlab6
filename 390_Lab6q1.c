#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>

int sum,csum,msum,upper;
void *runner();

int main(int argc, char *argv[]){
	pthread_t tid;
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	upper = atoi(argv[1]);	
	pthread_create(&tid, &attr, runner, argv[1]);

	if(upper > 0){
		for(int i = 0; i <= upper; i++)
			msum += i;
	}

	//pthread_join(tid,NULL);

	sum = csum-msum;
	printf("csum - msum = %d\n",sum);

	return 0;

}
void *runner(){
	int i;
	int upperx2 = upper * 2;
	if(upperx2 > 0){
		for(i = 0; i <= upperx2; i++)
			csum += i;
	}
	pthread_exit(0);

}
