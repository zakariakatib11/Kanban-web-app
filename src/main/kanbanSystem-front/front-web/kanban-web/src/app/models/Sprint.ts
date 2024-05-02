import { Task } from "./Task";

export class Sprint {
    id: number;
    name: string;
    startDate: Date;
    endDate: Date;
    tasks: Task[];
  
    constructor(
      id: number,
      name: string,
      startDate: Date,
      endDate: Date,
      tasks: Task[]
    ) {
      this.id = id;
      this.name = name;
      this.startDate = startDate;
      this.endDate = endDate;
      this.tasks = tasks;
    }
  }