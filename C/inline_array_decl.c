#define TWO 2

//
// Inline array declaration in C99
//
// Note in the second example (test2) that chars can be used as array indexes
// as well.
//

int main(void)
{
    int test[3] = {
        [0]   = 1,
        [1]   = 2,
        [TWO] = 3
    };

    int test2[255] = {
        ['a'] = 1,
        ['M'] = 4
    };

    return 0;
}
