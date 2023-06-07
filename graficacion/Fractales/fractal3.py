from turtle import *


shape("turtle")
speed(0)

def tree2(size, levels, angle):
    substract = 1 
    if levels == 0:
        return
    for i in range(10):
        forward(size + i)
        right(36)
        forward(size + i)
        right(36)
        forward(size + i)
        right(36)
        forward(size + i)
        right(36)

    tree2(size * 0.8, levels - substract, angle)
    left(90)

left(90)
color("red")
forward(50)
tree2(20, 10, 90)
mainloop()
