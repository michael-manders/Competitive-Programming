import React, { useState, useEffect } from "react";
import { Bar } from "react-chartjs-2";

import "../assets/css/BarChart.css";

const BarChart = ({ width, height, barWidth, filePath, label, max }) => {
    const [data, setData] = useState([]);
    const [visibleBars, setVisibleBars] = useState(60);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(filePath);
                const csvText = await response.text();
                // console.log(csvText);
                const csvData = csvText
                    .trim()
                    .split("\n")
                    .map((row) => row.split(","));

                // Transpose the CSV data
                const transposedData = csvData[0].map((_, colIndex) =>
                    csvData.map((row) => row[colIndex])
                );

                // console.log(transposedData);

                // Assuming the first row contains labels and the rest contain values
                const formattedData = transposedData.slice(1).map((row) => ({
                    label: row[0],
                    value: parseInt(row[1], 10),
                }));

                console.log(formattedData);

                setData(formattedData);
            } catch (error) {
                console.error("Error fetching or parsing CSV data:", error);
            }
        };

        // Initial fetch
        fetchData();

        // Fetch data every 5 seconds
        const intervalId = setInterval(fetchData, 1000);

        // Cleanup the interval on component unmount
        return () => clearInterval(intervalId);
    }, [filePath]); // Added filePath as a dependency

    const options = {
        maintainAspectRatio: false,
        legend: { display: false },
        scales: {
            x: {
                type: "category",
                ticks: { beginAtZero: true, stepSize: 5 },
            },
            y: {
                ticks: { beginAtZero: true },
                max: max || undefined,
            },
        },
    };

    return (
        <div style={{ width, height, overflowX: "auto" }}>
            <div style={{ width: data.length * barWidth, display: "flex" }}>
                <Bar
                    data={{
                        labels: data
                            .slice(Math.max(0, data.length - visibleBars))
                            .map((item) => 60 - item.label + 1),
                        datasets: [
                            {
                                label: label,
                                data: data
                                    .slice(
                                        Math.max(0, data.length - visibleBars)
                                    )
                                    .map((item) => item.value),
                                backgroundColor: "rgba(75,192,192,0.2)",
                                borderColor: "rgba(75,192,192,1)",
                                borderWidth: 1,
                                barThickness: barWidth,
                            },
                        ],
                    }}
                    options={options}
                />
            </div>
            <div className="realnum">
                <p>{label}</p>
                <p>
                    {": "} <b>{data[data.length - 1]?.value}</b>
                </p>
            </div>
        </div>
    );
};

export default BarChart;

// import React, { useState, useRef, useEffect } from "react";
// import * as d3 from "d3";

// const BarChart = () => {
//     const [data] = useState([200, 250, 60, 150]);
//     const svgRef = useRef();

//     useEffect(() => {
//         const margin = { top: 50, right: 30, bottom: 50, left: 30 };
//         const w = 300 - margin.right - margin.left;
//         const h = 400 - margin.top - margin.bottom;

//         d3.select(svgRef.current).selectAll("*").remove();

//         const svg = d3
//             .select(svgRef.current)
//             // .append("svg")
//             .attr("width", w + margin.right + margin.left)
//             .attr("height", h + margin.top + margin.bottom)
//             .append("g")
//             .attr("transform", `translate(${margin.left},${margin.top})`);

//         const xScale = d3
//             .scaleBand()
//             .domain(data.map((val, i) => i))
//             .range([0, w])
//             .padding(0.2);

//         const yScale = d3
//             .scaleLinear()
//             .domain([0, d3.max(data)]) // 0, max of csv
//             .range([h, 0]);

//         const xAxis = d3.axisBottom(xScale);
//         //.ticks(data.length);
//         const yAxis = d3.axisLeft(yScale); //.ticks(5);

//         svg.append("g")
//             .attr("transform", `translate(0, ${h})`)
//             .call(xAxis)
//             .selectAll("text")
//             .attr("transform", "translate(-10,0)rotate(-45)")
//             .style("text-anchor", "end");

//         svg.append("g").call(yAxis);

//         svg.selectAll("bar")
//             .data(data)
//             .join("rect")
//             .attr("x", (v, i) => xScale(i))
//             .attr("y", (v) => yScale(v))
//             .attr("width", xScale.bandwidth())
//             .attr("height", (val) => h - yScale(val))
//             .attr("fill", "steelblue");
//     }, [data]);

//     return (
//         <div>
//             <svg ref={svgRef}></svg>
//         </div>
//     );
// };

// export default BarChart;

// // import React, { useState, useEffect }
