#
# ARGF reads from either STDIN or file(s) specified in params
#

ARGF.each { |file|
    file.each_line { |line|
        puts line
    }
}

