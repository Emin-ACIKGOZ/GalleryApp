# GalleryApp

GalleryApp is an Android application that allows users to view a collection of pictures with the names and descriptions of the picture.

## Features

- **Image Gallery**: The app displays a collection of images with their associated names and descriptions.
- **Composable UI**: The UI is entirely made using Composable Functions in Jetpack Compose.
- **Adaptive Layout**: The layout adapts to different screen sizes and screen orientations.
- **Theming**: The app uses Material 3 theming to have a modern look.

## Project Structure

- **`MainActivity.kt`**: The entry point of the app. It sets up the Compose UI and applies the app's theme.
- **`GalleryLayout` Composable**: This is the main UI component that displays the current image and text, along with buttons to move through the gallery.
- **`ImageWithText` Composable**: A helper composable that displays an image along with its name and description.
- **`ImageData` Data Class**: Holds the image and text resources for each item in the gallery.

## How It Works

1. **Image Data**: The images and their associated text resources are stored in a list of `ImageData` objects.
2. **Composable Layout**: The `GalleryLayout` composable arranges the image and text vertically and centers them on the screen.
3. **Preview**: The app includes a `@Preview` function to allow developers to see how the UI will look directly within Android Studio without running the app on a device.

## How to Use

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.

## Customization

- **Adding/Removing Images**: To add or remove images from the gallery, modify the `images` list in the `GalleryLayout` composable.
- **Changing Themes**: The app's theme can be customized by editing the `GalleryAppTheme` in the `ui.theme` package.

## Dependencies

- **Jetpack Compose**: For building the UI.
- **Material 3**: For theming and material design components.
