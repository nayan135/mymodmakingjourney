# Texture Files for Nayan Blocks

To complete the implementation of the nayan, nayan1, and nayan2 blocks, you need to copy the following texture files from the item directory to the block directory:

1. Copy `../item/nayan.png` to `nayan.png` in this directory
2. Copy `../item/nayan1.png` to `nayan1.png` in this directory
3. Copy `../item/nayan2.png` to `nayan2.png` in this directory

This is necessary because the block models reference textures in the block directory, while the original textures are in the item directory.

## Manual Steps Required

Since these are binary files, they need to be copied manually. Use your file explorer to:

1. Navigate to `src/main/resources/assets/mymodnayan135/textures/item/`
2. Copy the nayan.png, nayan1.png, and nayan2.png files
3. Navigate to `src/main/resources/assets/mymodnayan135/textures/block/`
4. Paste the files in this directory

After completing these steps, the mod will be able to properly display the nayan blocks.