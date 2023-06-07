from tkinter import *
from math import cos, sin, radians

class DrawingApp:
    def __init__(self, master):
        self.master = master
        self.master.title("Drawing App")
        self.canvas = Canvas(self.master, width=800, height=600)
        self.canvas.pack()
        self.shape = None
        self.start_x = 0
        self.start_y = 0
        self.canvas.bind("<Button-1>", self.start_drawing)
        self.canvas.bind("<B1-Motion>", self.draw)
        
    def start_drawing(self, event):
        self.start_x = event.x
        self.start_y = event.y
        
    def draw(self, event):
        if self.shape:
            self.canvas.delete(self.shape)
            
        shape_type = shape_var.get()
        
        if shape_type == "Line":
            self.shape = self.canvas.create_line(self.start_x, self.start_y, event.x, event.y)
        elif shape_type == "Square":
            self.shape = self.canvas.create_rectangle(self.start_x, self.start_y, event.x, event.y)
        elif shape_type == "Triangle":
            self.shape = self.canvas.create_polygon(self.start_x, self.start_y, event.x, event.y, self.start_x, event.y)
        elif shape_type == "Rectangle":
            self.shape = self.canvas.create_rectangle(self.start_x, self.start_y, event.x, event.y)
            
    def scale_shape(self):
        scale_factor = float(scale_factor_entry.get())
        self.canvas.scale(self.shape, self.start_x, self.start_y, scale_factor, scale_factor)
        
    def translate_shape(self):
        dx = int(translate_x_entry.get())
        dy = int(translate_y_entry.get())
        self.canvas.move(self.shape, dx, dy)

root = Tk()
shape_var = StringVar()
shape_var.set("Line")

app = DrawingApp(root)

shape_label = Label(root, text="Shape:")
shape_label.pack()

shape_options = OptionMenu(root, shape_var, "Line", "Square", "Triangle", "Rectangle")
shape_options.pack()

scale_label = Label(root, text="Scale Factor:")
scale_label.pack()

scale_factor_entry = Entry(root)
scale_factor_entry.pack()

scale_button = Button(root, text="Scale", command=app.scale_shape)
scale_button.pack()

translate_label = Label(root, text="Translate:")
translate_label.pack()

translate_x_entry = Entry(root)
translate_x_entry.pack()

translate_y_entry = Entry(root)
translate_y_entry.pack()

translate_button = Button(root, text="Translate", command=app.translate_shape)
translate_button.pack()

root.mainloop()
