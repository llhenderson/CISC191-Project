import java.awt.Image;

public class Block {
        int x;
		int y;
		int width;
		int height;
		Image image;
		
		int startX;
		int startY;
		char direction = 'U';
		int velocityX =0;
		int velocityY = 0;
		
		Block(Image image, int x, int y, int width, int height){
			this.image = image;
			this.x = x;
			this.y = y;
			this.height = height;
			this.width = width;
			this.startX = x;
			this.startY = y;

		}
}