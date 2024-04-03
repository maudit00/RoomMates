import { iUser } from "./iUser"

export interface iBills {
  id: number
  users: iUser
  description: string
  amount: number
  date: string
  deadline: string
}
