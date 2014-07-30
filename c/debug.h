//
// Debug Logging for C
//   Full post at: <https://abstractowl.github.io/2014/05/13/debug-logging-in-c.html>
//

#include <stdio.h>

#define LOG_NONE  (0)
#define LOG_WARN  (1)
#define LOG_INFO  (2)

#define WARN(...)
#define INFO(...)

#define LOG_LEVEL LOG_INFO // Set log level here

#define LOG(msg, args...) \
  do { \
    printf("[%s] (%s:%d) " msg "\n", __func__, __FILE__, __LINE__, ##args); \
  } while (0)

#if LOG_LEVEL >= LOG_WARN
  #undef WARN
  #define WARN(msg, args...) LOG("WARN - " msg, ##args)
#endif

#if LOG_LEVEL >= LOG_INFO
  #undef INFO
  #define INFO(msg, args...) LOG("INFO - " msg, ##args)
#endif
