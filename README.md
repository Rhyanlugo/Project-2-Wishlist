# Android Project 2 - *Curios*

Submitted by: **Rhyan Lugo Crespo**

**Curios** is a wishlist app that helps the user keep track of what they want to buy.

Time spent: **12** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **User can add an item to their wishlist**
- [x] **User can see their list of items based on previously inputted items**

The following **optional** features are implemented:

- [x] Wishlist app is 🎨 **customized** 🎨
- [x] User can delete an item by long pressing on the item
- [x] User can open an item's URL by clicking on the item

The following **additional** features are implemented:

* [x] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/Rhyanlugo/Project-2-Wishlist/blob/master/Wishlist.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

<!-- Replace this with whatever GIF tool you used! -->
GIF created with [ScreenToGif](https://www.screentogif.com/) for Windows  
<!-- Recommended tools: 
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes

Describe any challenges encountered while building the app.

Setting up the base features wasn't too difficult and adding a new item to the Recycler View was a little tricky at 
first to figure out but using the lab as a reference it wasn't too difficult to figure out. Out of all the stretch features, 
the most difficult was definitely the one to delete an item by long pressing. That's probably the thing that I spent the most time
on trying to figure out. Once I finally checked if the Recycler View resource page had any resources for clicking on an item, 
I was able to figure out how to get the long press to work eventually. Opening the url based on the inputted url was also a little tricky 
at first since I tried to add another listener, but just for clicking and not long clicking. That didn't work but then I remembered
I could just add an OnClickListener to the textview with the provided code inside the lamba function and that was that feature finished.
## License

    Copyright [2022] [Rhyan Lugo Crespo]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
