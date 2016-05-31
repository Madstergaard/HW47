 
int numBalls = 24;

Ball[] balls = new Ball[numBalls];

void setup() {
  size(500,500);
  for (int i = 0; i < numBalls; i++) {
    float r = random(255);
    float g = random(255);
    float b = random(255);
 
    color myColor = color(r, g, b);
    balls[i] = new Ball(random(width), random(height), 10, random(-2, 2), random(-2, 2), myColor);
  }

}

void draw() {
  background(255);
  for (Ball ball : balls) {
    ball.display(); 
    ball.move();
    ball.bounce();
  }
}

class Ball {
  
  float x, y;
  float diameter;
  float vx = 0;
  float vy = 0;
  color ballcolor;
 
  Ball(float xin, float yin, float d, float xvel, float yvel, color bcolor) {
    x = xin;
    y = yin;
    diameter = d;
    vx = xvel;
    vy = yvel;
    ballcolor = bcolor;
  } 
  
  void display() {
    fill(ballcolor);
    ellipse(x, y, diameter, diameter);
  }
  void move() {
    x += vx;
    y += vy;
  }
  
  void bounce() {
    if (x > width || x < 0) { vx = -vx;}
    if (y > height || y < 0) { vy = -vy;}
  }
}
