import turtle

def sierpinski(length, depth):
    if depth == 0:
        for i in range(6):
            turtle.color("red")
            turtle.forward(length*2)
            turtle.left(60)
    else:
        sierpinski(length, depth-1)
        turtle.forward(length)
        turtle.right(30)
        sierpinski(length, depth-1)
        turtle.forward(length)
        turtle.right(60)
        sierpinski(length, depth-1)
        turtle.backward(length)
        turtle.left(90)

def sierpinski2(length, depth):
    if depth == 0:
        for i in range(6):
            turtle.color("red")
            turtle.forward(length*2)
            turtle.left(60)
    else:
        sierpinski(length, depth-1)
        turtle.forward(length)
        turtle.left(30)
        sierpinski(length, depth-1)
        turtle.forward(length)
        turtle.left(60)
        sierpinski(length, depth-1)
        turtle.backward(length)
        turtle.right(90)

def sierpinski3(length, depth):
    if depth == 0:
        for i in range(6):
            turtle.color("green")
            turtle.forward(length*2)
            turtle.left(60)
    else:
        turtle.forward(length * 2)

        turtle.left(90)
        sierpinski3(length, depth-1)
        turtle.forward(length)
        turtle.left(60)
        sierpinski3(length, depth-1)
        turtle.backward(length)
        turtle.left(90)


def funcion():
    turtle.speed("fastest")
    sierpinski(20, 3)
    turtle.left(120)
    sierpinski2(20, 3)
    turtle.left(240)
    sierpinski(20, 2)
    turtle.left(200)
    sierpinski3(20, 2)
    sierpinski3(20, 2)
    sierpinski3(20, 2)
    turtle.done()

if __name__ == "__main__":
    funcion()
