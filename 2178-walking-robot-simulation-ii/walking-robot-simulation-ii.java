class Robot {
    private int width;
    private int height;
    private int pos;
    private int perimeter;
    private boolean hasMoved;
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height - 2);
        this.pos = 0;
        this.hasMoved = false;
    }
    
    public void step(int num) {
        hasMoved = true;
        pos = (pos + num) % perimeter;
    }
    
    public int[] getPos() {
        if(pos < width){
            return new int[]{pos,0};
        }
        if(pos < width + height - 1){
            return new int[]{width-1,pos - (width - 1)};
        }
        if(pos < 2 * width + height - 2){
            return new int[]{width - 1 - (pos - (width+height-2)),height - 1};
        }
        return new int[]{0,perimeter-pos};
    }
    
    public String getDir() {
        if (!hasMoved || pos == 0) {
            if (hasMoved && pos == 0) return "South";
            return "East";
        }

        if (pos <= width - 1) {
            return "East";
        } else if (pos <= width + height - 2) {
            return "North";
        } else if (pos <= 2 * width + height - 3) {
            return "West";
        } else {
            return "South";
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */