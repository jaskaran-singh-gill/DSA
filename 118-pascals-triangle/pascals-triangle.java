class Solution {
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> triangleData = new ArrayList<>(numRows);
        for (int layerIdx = 0; layerIdx < numRows; layerIdx++) {
            List<Integer> rowData = new ArrayList<>(layerIdx + 1);
            rowData.add(1);
            for (int colIdx = 1; colIdx < layerIdx; colIdx++) {
                List<Integer> prevData = triangleData.get(layerIdx - 1);
                rowData.add(prevData.get(colIdx - 1) + prevData.get(colIdx));
            }
            if (layerIdx > 0) rowData.add(1);
            triangleData.add(rowData);
        }
        return triangleData;
    }
}