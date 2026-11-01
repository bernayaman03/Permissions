# Permissions

An Android application developed with Kotlin as part of a university assignment. The project demonstrates camera integration, image handling, and SMS functionality using Android APIs.

## Features

- Accepts a phone number entered by the user.
- Opens the device's camera application using `ACTION_IMAGE_CAPTURE`.
- Initiates an SMS with the message "Telefondan fotoğraf çekildi" when the camera is launched.
- Displays the captured photo in an `ImageView` after a successful camera result.
- Provides Toast messages for user feedback.

## Technologies

- Kotlin
- Android SDK
- XML Layouts
- Android Intents
- `SmsManager`

## Permissions

The application declares camera and SMS permissions in `AndroidManifest.xml`.

## About

This project was developed to explore Android permissions, camera intents, and SMS integration through a simple mobile application.
