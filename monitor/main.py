import tkinter
import customtkinter
import random

# Setting up theme of GUI
customtkinter.set_appearance_mode("Dark")  # Modes: "System" (standard), "Dark", "Light"
customtkinter.set_default_color_theme("blue")  # Themes: "blue" (standard), "green", "dark-blue"

class App(customtkinter.CTk):
    def __init__(self):
        super().__init__()
        # configure window
        self.is_on = True
        self.title("Dashboard")
        self.geometry("800x480")
        self.temperature = tkinter.IntVar()
        self.mood = tkinter.StringVar()
        self.font = self.get_main_font()
        # create frame for environmental variable
        self.temperature_frame = customtkinter.CTkFrame(self)
        self.temperature_frame.grid(row=0, column=0, rowspan = 2, padx=1, pady=1, sticky="n")

        self.label_temperature = customtkinter.CTkLabel(master=self.temperature_frame, text="Temperature")
        self.label_temperature.grid(row=0, column=1, padx=10, pady=10, sticky="")

        self.label_temperature_value = customtkinter.CTkLabel(
            master=self.temperature_frame, textvariable=self.temperature, font=self.font)
        self.label_temperature_value.grid(row=1, column=1, columnspan=1, padx=10, pady=10, sticky="")

        self.label_temperature_value = customtkinter.CTkLabel(
            master=self.temperature_frame, text = f'\N{DEGREE CELSIUS}', font=self.font)
        self.label_temperature_value.grid(row=1, column=2, columnspan=1, padx=10, pady=10, sticky="")
        self.get_temp()
        self.mood_frame = customtkinter.CTkFrame(self)
        self.mood_frame.grid(row=2, column=0, rowspan = 2, padx=1, pady=1, sticky="n")

        self.label_mood = customtkinter.CTkLabel(master=self.mood_frame, text="Mood")
        self.label_mood.grid(row=2, column=1, columnspan=1, padx=10, pady=10, sticky="")

        self.label_mood_value = customtkinter.CTkLabel(
            master=self.mood_frame, textvariable=self.mood, font=self.font)
        self.label_mood_value.grid(row=3, column=1, columnspan=1, padx=10, pady=10, sticky="")

        self.label_mood_value = customtkinter.CTkLabel(
            master=self.mood_frame, text = '   ', font=self.font)
        self.label_mood_value.grid(row=3, column=2, columnspan=1, padx=10, pady=10, sticky="")
        self.get_mood()


    def get_main_font(self):
        return customtkinter.CTkFont(size=50, weight="bold")

    def get_temp(self):
        self.temperature.set(Temp.current()) 
        self.after(2000, self.get_temp)

    def get_mood(self):
        self.mood.set('ON')

class Temp:
    temp = random.randint(10,35)
    def current():
        diff = random.randint(-3,3)
        return Temp.temp + diff

if __name__ == "__main__":
    app = App()
    app.mainloop()