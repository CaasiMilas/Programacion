from turtle import *


shape("turtle")
speed(0)

def tree(size, levels, angle):
    varible_size = 0.8
    substract = 1 
    if levels == 0:
        return

    forward(size)
    right(angle)
    tree(size * varible_size, levels - substract, angle)
    left(angle)
    tree(size * varible_size, levels - substract, angle)
    right(angle)
    # tree(size * varible_size, levels - substract, angle)

left(90)
tree(50, 10, 90)
mainloop()
