import { Board } from "./Board";
import { User } from "./User";
import { TaskStatus } from "./TaskStatus";
import { Sprint } from "./Sprint";

export class Task {
    id: number;
    name: string;
    description: string;
    status: TaskStatus;
    estimation: number;
    board: Board;
    users: User[];
    sprints: Sprint[];
  
    constructor(
      id: number,
      name: string,
      description: string,
      status: TaskStatus,
      estimation: number,
      board: Board,
      users: User[],
      sprints: Sprint[]
    ) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.status = status;
      this.estimation = estimation;
      this.board = board;
      this.users = users;
      this.sprints = sprints;
    }
  }
  
