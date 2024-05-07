export class BoardDTO {
    name: string;
    description: string;
    dateCreation: Date;
  
    constructor(name: string, description: string, dateCreation: Date) {
      this.name = name;
      this.description = description;
      this.dateCreation = dateCreation;
    }
  }
  