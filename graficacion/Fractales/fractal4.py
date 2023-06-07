from turtle import *


shape("turtle")
speed(0)

def tree2(size, levels, angle):
    substract = 1 
    if levels == 0:
        return

    forward(size + 1)
    right(120)
    forward(size + 1)
    right(120)
    forward(size + 1)
    right(120)

    left(180)
    tree2(size, levels - substract, angle)
    right(180)
    tree2(size, levels - substract, angle)
    right(90)
    tree2(size, levels - substract, angle)

def hexa(levels):
    if levels == 0:
        return
    left(90)
    color("blue")
    for h in range(6):
        forward(50)
        left(60)
    hexa(levels-1)

    forward(50)
    right(90)
    hexa(levels-1)
    forward(50)
    right(90)
    hexa(levels-1)


forward(50)
right(60)
left(90)
color("red")
forward(50)
tree2(50, 5, 90)
hexa(5)


mainloop()
