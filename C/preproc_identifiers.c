#include <stdio.h>

// Interesting preprocessor identifiers

void run(void)
{
    printf("__FILE__: %s\n", __FILE__);
    printf("__func__: %s\n", __func__);
    printf("__LINE__: %d\n", __LINE__);
    printf("__DATE__: %s\n", __DATE__);
    printf("__TIME__: %s\n", __TIME__);
}

int main(void)
{
    run();
    return 0;
}
