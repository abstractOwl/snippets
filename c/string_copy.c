#include <stdio.h>

/**
 * Copies one string into another char array. This works because assignment
 * returns the value that was assigned. Thus, when the null-terminator is
 * assigned, the expression returns 0 and the while loop ends.
 *
 * WARNING:
 *   PLEASE DO NOT USE THIS IN ANY SERIOUS CODE AS IT IS VULNERABLE TO BUFFER
 *   OVERRUNS.
 *
 * Note that this snippet has several disadvantages:
 * - Depends on null-terminator
 * - No bounds checking of either src or dest
 * - Only works for strings
 * - Not maintainable
 *
 * Inspired by:
 * academiccomputing.wordpress.com/2014/06/09/the-ugliest-beautiful-line-of-code
 *
 * @param src  string to copy from
 * @param dest char buffer to copy to
 */
void string_copy(const char *src, char *dest) { while ((*dest++ = *src++)); }

int main(void)
{
    // Normal usage
    char buf[20];
    string_copy("Hello world!", buf);
    printf("%s\n", buf);

    // Because there is no null terminator, string_copy continues copying past
    // the end of the input buffer, exposing data past the end of the string.
    const char test[3] = { 'a', 'b', 'c' };
    string_copy(test, buf);
    printf("%s\n", buf);

    return 0;
}
