# Numbers List

The goal of this project is enlist a series of numbers introduced by the user, with a simple interface and with a well-thinked and minimalistic design process. The user should be able to introduced any number with no more of 5 digits, repeted numbers are allowed, and the must be displayed in a dynamic list, in this case, the component that allows this behavior is a `ListView`.

## Features

- Every `ListItem` displays the value entered by the user, its hexadecimal value and the register date. This additional data is just informative and as an extra from the original exercise.
- A `Clear` button was added, with the intention of letting the user to restart the process in case he wanted.
- An `Order` button was added too. Its functionallity is the following:
  - **By default**, the order of the list is showing the items in the order they were added.
  - Then, the button will alternate with **Ascendant** and **Descendant** order, starting with ascendant.
  I decided that this functionallity was better than having 2 buttons for both types of ordering.
- If `Add` button is clicked, it verifys that the input has a value entered, if not, it will display an error.
- Repeated numbers are allowed

### Translation

The app suports **Spanish** and **English** translations

## Developer

Sebastián Arjona Méndez Albarrán
