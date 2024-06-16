cmake_minimum_required(VERSION 3.4.1)

set(TARGET_NAME kiocode)

add_library(${TARGET_NAME} SHARED
        native-lib.cpp
        KittyMemory/KittyMemory.cpp
        KittyMemory/KittyUtils.cpp
        Substrate/SubstrateDebug.cpp
        Substrate/SubstrateHook.cpp
        Substrate/SubstratePosixMemory.cpp
        Substrate/SymbolFinder.cpp
        Substrate/hde64.c
)

include_directories(
        ${CMAKE_SOURCE_DIR}/Includes
        ${CMAKE_SOURCE_DIR}/KittyMemory
        ${CMAKE_SOURCE_DIR}/Substrate
)

find_library(log-lib log)

target_link_libraries(${TARGET_NAME}
        ${log-lib}
        android
        EGL
        GLESv2
)

target_compile_options(${TARGET_NAME} PRIVATE
        -Wno-error=format-security
        -fpermissive
        -fvisibility=hidden
        -fvisibility-inlines-hidden
        -fno-rtti
        -fno-exceptions
        -g0
        -fomit-frame-pointer
        -ffunction-sections
        -fdata-sections
)
