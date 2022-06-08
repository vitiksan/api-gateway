## Smart Town

### Usage of the project

There is small smart town with town houses.
Each town house contains water/gas/electricity quality control sensors and usage tracking sensors.

This project is designed to gather data from the sensor mentioned above and generate statistic and predictions for that.

### Simple Workflow

Structure:
Sensors (generates records) -> Non-Relational DB -> Filter
Filter (reduces amount of data by filtering and merging it)
Filter -> API -> relational DB (postgres)
DB -> statistics & analysis

### Water
Water usage analysis and prediction in city;</br>
Water quality control;

#### Drinking water quality:
1) Other water quality
2) Drinking water usage
3) Other water usage

#### For analysis and prediction:
1) Gain information of water quality changes and water amount used;
2) Analyze how much water is used per person per day/per month
3) Analyze how much water is used by аfully populated smart town per month/per year to predict how much is going to be needed for same smart town.
4) Analyze how often filtered water quality becomes unfit for consumption to predict filters amount needed in future
5) Analyze water usage per season to predict in what season smart town needs more water

### Electricity 

Electricity usage analysis and prediction in city;</br>
Electricity quality control;

Electricity stats

1) Total value of electricity used (per month/year)
2) Electricity used compared to previous month/this month last year

Graphs
1) Electricity used per month (comparing last years/predictions for next year(s))
https://www.iea.org/reports/monthly-electricity-statistics-overview/data-explorer

### Gas

Gas usage analysis and prediction in city;</br>
Gas quality control;

#### Statistic and prediction:
1) Total amount of gas used per year / month / day / hour (during a day)
2) The amount of gas used per year / month / day / hour per house
3) Average amount of gas used per person per year / month
4) Increase in gas use per year
5) Top N months of the year with the highest gas use
6) Top N months of the year with the least gas use
7) Expected amount of gas used next year (according to the expected number of residents)
8) Number of incidents with out-of-norm quality indicators (length in time) per year / month
9) Percentage of time when gas is supplied within the norm according to the indicators for the year / month
10) The level of deviation from the norm and time frames for each incident

### Kafka setup/run script
You can find bash scripts to start zookeeper/kafka and create topics here: </br>
`src/main/resources/kafka_initialization_mac.sh`
`src/main/resources/kafka_initialization_win.sh`





