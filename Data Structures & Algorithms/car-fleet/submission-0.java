class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
        i = car
        position <the  

        */
        // construct the data structrue
        Map<Integer, Integer> fleetMap = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            fleetMap.put(position[i], speed[i]);
        }

        // iterate through the list, updating the car position every iteration until all the cars reach the target
        // update the car position by the speed it is going at
        // if 2 cars have the same position then choose the speed of the lesser car, now this will be combined 1 "car"/fleet
        // +1 to the result after a fleet has reached the target.
        int result = 0;
        while (!fleetMap.isEmpty()) {
            Map<Integer, Integer> newFleetMap = new HashMap<>();
            fleetMap.forEach((oldPos, spd) -> {
                Integer newPos = oldPos + spd;
                if (newPos > target) {
                    newPos = target;
                }
                if (!newFleetMap.isEmpty() && newFleetMap.containsKey(newPos)) {
                    Integer otherSpeed = newFleetMap.get(newPos);
                    if (spd < otherSpeed) {
                        newFleetMap.put(newPos, spd);
                    }
                } else {
                    newFleetMap.put(newPos, spd);
                }
            });
            fleetMap = newFleetMap;
            if (fleetMap.containsKey(target)) {
                ++result;
                fleetMap.remove(target);
            }
        }
        return result;
    }
}
