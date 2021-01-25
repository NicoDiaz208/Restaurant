import { Reservation } from "./reservation";

export class Table {
    constructor(public id:number, public reservations:Reservation[], public chairs:number){}
}
