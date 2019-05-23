import java.util.Random;

class Character {
	int x = 0, y = 0;
	String name = "PUUDUB";
	CharType charType = CharType.PLAYER;
	Direction dir = Direction.RIGHT;

	public Character(String _name, CharType _charType) {
		name = _name;
		Random rand = new Random();
		x = rand.nextInt(10);
		y = rand.nextInt(10);
		charType = _charType;
	}

	public void move() {
		if(dir == Direction.RIGHT) { x++; }
		if(dir == Direction.LEFT) { x--; }
		if(dir == Direction.UP) { y++; }
		if(dir == Direction.DOWN) { y--; }
	}

	public void setDirection(Direction _dir) {
		dir = _dir;
	}

	public int getDistanceBetweenCharacter(Character character) {
		int dx = character.x-x;
		int dy = character.y-y;
		if(dx < 0) { dx = -dx; }
		if(dy < 0) { dy = -dy; }
		return dx+dy;
	}

	public String toString() {
		return name+" "+charType+" kohal "+x+" "+y+" suunaga "+dir;
	}
}