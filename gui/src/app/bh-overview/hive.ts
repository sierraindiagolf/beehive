export class Hive {
  hasSensors: boolean;
  id: Number;
  location: Object;
  macAddress: String;
  nextVisit: Date;
  owner: String;
  sensorDataSet: Array<Object>;
  type: String;
  visits: Array<any>;
  yearOfTheLastQueenChange: Number;
}
