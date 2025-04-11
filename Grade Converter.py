class GradeConverter:
    def __init__(self):
        self.x1 = 0
        self.y1 = 0
        self.x2 = 0
        self.y2 = 0

    def set_coordinates(self, x1, y1, x2, y2):
        self.x1, self.y1, self.x2, self.y2 = x1, y1, x2, y2

    def find_y_coordinate(self, new_x):
        slope = (self.y2 - self.y1) / (self.x2 - self.x1)
        return -slope * (self.x2 - new_x) + self.y2

    def find_x_coordinate(self, y_value):
        slope = (self.y2 - self.y1) / (self.x2 - self.x1)
        y_intercept = self.y1 - slope * self.x1
        return (y_value - y_intercept) / slope

    def input_grading_system(self):
        print("Welcome to Grade Converter.")
        print("This program converts the 5-point scale system into its percentage equivalent, and vice versa.")
        print()
        converter = None
        grading_system_choice = None

        while grading_system_choice != '2':
            print("Select a grading system:")
            print("Type a for University of the Philippines (1 = 97, 1.25 = 94.25, 1.5 = 91.5)")
            print("Type b for University of Santo Tomas (1 = 96, 1.25 = 94, 1.5 = 92)")
            print("Type c for Ateneo University (4 = 92, 3.5 = 88, 3 = 84)")
            print("Type d for De La Salle University (4 = 95, 3.5 = 89, 3 = 83)")
            print("Type e for Mapúa University (1 = 98, 1.25 = 95, 1.5 = 92)")
            print("Type f to enter your own grading system.")
            print()

            grading_system_choice = input().lower()
            if grading_system_choice in {'a', 'b', 'c', 'd', 'e', 'f'}:
                if grading_system_choice == 'f':
                    print()
                    print("Example:")
                    print("x1 = 1.25, y1 = 94.25")
                    print("x2 = 1.5, y2 = 91.5")
                    print()
                    print("Enter grading system:")
                    print()
                    custom_x1 = float(input("x1 = "))
                    custom_y1 = float(input("y1 = "))
                    custom_x2 = float(input("x2 = "))
                    custom_y2 = float(input("y2 = "))
                    converter = GradeConverter()
                    converter.set_coordinates(custom_x1, custom_y1, custom_x2, custom_y2)
                else:
                    converter = GradeConverter()
                    coordinates_dict = {'a': (1.25, 94.25, 1.5, 91.5),
                                        'b': (1.25, 94, 1.5, 92),
                                        'c': (3.5, 88, 3, 84),
                                        'd': (3.5, 89, 3, 83),
                                        'e': (1.25, 95, 1.5, 92)}
                    converter.set_coordinates(*coordinates_dict[grading_system_choice])
            else:
                print()
                print("Invalid choice. Please try again.")
                continue

            while True:
                print()
                choice = input("Type 1 to find Percentage Grade, or 2 to find Grade Point: ")
                if choice == '1':
                    print()
                    new_x = float(input("Enter grade: "))
                    result_y = converter.find_y_coordinate(new_x)
                    print(f"5 Point Scale = {new_x}, Percentage = {result_y}")
                elif choice == '2':
                    print()
                    y_value = float(input("Enter percentage: "))
                    result_x = converter.find_x_coordinate(y_value)
                    print(f"Percentage = {y_value}, 5 Point Scale = {result_x}")
                else:
                    print()
                    print("Invalid choice. Please type 1 or 2.")
                    continue

                repeat_choice = None
                while repeat_choice not in {'1', '2'}:
                    print()
                    repeat_choice = input("Type 1 to try again, or 2 to change the grading system: ")
                    if repeat_choice not in {'1', '2'}:
                        print()
                        print("Invalid choice. Please try again.")
                if repeat_choice == '2':
                    print()
                    break

if __name__ == "__main__":
    GradeConverter().input_grading_system()
